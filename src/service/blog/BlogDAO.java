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
    public void insertBlog(Blog blog) {

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
