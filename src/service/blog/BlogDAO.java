package service.blog;

import model.Blog;
import service.DBConnection;
import service.user.UserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogDAO implements IBlogDAO {
    private Connection connection;
    private static BlogDAO instance;
    public BlogDAO() {
        this.connection = DBConnection.getConnection();
    }
    public static BlogDAO getInstance() {
        if (instance == null) {
            instance = new BlogDAO();
        }
        return instance;
    }

    @Override
    public List<Blog> selectBlogByNickName(String nickName) throws SQLException {
        List<Blog> blogByMe = new ArrayList<>();
        String sql = "call selectBlogByAuthor(?)";
        CallableStatement statement = connection.prepareCall(sql);
        statement.setString(1,nickName);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String header = resultSet.getString(2);
            String author = resultSet.getString(4);
            Timestamp date = resultSet.getTimestamp(5);
            int category_id = resultSet.getInt(6);
            String censor = resultSet.getString(7);
            Blog blog = new Blog(header,author,category_id,date,censor);
            blogByMe.add(blog);
        }
        return blogByMe;
    }

    @Override
    public void insertBlog(Blog blog) throws SQLException {
        String insetBlog = "call insertBlog(?,?,?,?,?)";
        CallableStatement statement = connection.prepareCall(insetBlog);
        statement.setString(1,blog.getHeader());
        statement.setString(2,blog.getContent());
        statement.setString(3,blog.getAuthor());
        statement.setTimestamp(4,blog.getDate());
        statement.setInt(5,blog.getCategory_id());
        statement.executeUpdate();
    }

    @Override
    public Blog selectBlog(int id) {
        return null;
    }

    @Override
    public List<Blog> selectAllBlogApproved() throws SQLException {
        List<Blog> blogList = new ArrayList<>();
        String getAllBlogApproved = "call getAllBlogApproved(?)";
        CallableStatement statement = connection.prepareCall(getAllBlogApproved);
        statement.setInt(1,1);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String header = resultSet.getString("header");
            String author = resultSet.getString("author");
            Timestamp date = resultSet.getTimestamp("date");
            int category_id = resultSet.getInt("category_id");
            int status = resultSet.getInt("status");
            blogList.add(new Blog(header,author,date,category_id,status));
        }
        return blogList;
    }

    @Override
    public List<Blog> selectAllBlogIsPending() {
        return null;
    }

    @Override
    public boolean deleteBlog(int id) {
        return false;
    }

    @Override
    public boolean updateBlog(Blog blog) {
        return false;
    }
}
