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
    public void insertBlogByAdmin(Blog blog) throws SQLException {
        String insetBlogByAdmin = "INSERT INTO blogs(header, content, author, date, category_id, censor, status) values (?,?,?,?,?,?,?);";
        PreparedStatement statement = connection.prepareStatement(insetBlogByAdmin);
        statement.setString(1,blog.getHeader());
        statement.setString(2,blog.getContent());
        statement.setString(3,blog.getAuthor());
        statement.setTimestamp(4,blog.getDate());
        statement.setInt(5,blog.getCategory_id());
        statement.setString(6,blog.getCensor());
        statement.setInt(7,blog.getStatus());
        statement.executeUpdate();
    }
    @Override
    public Blog selectBlogById(int id) throws SQLException {
        Blog blog = null;
        String searchBlogById = "select * from blogs where id = ?;";
        PreparedStatement pstm = connection.prepareStatement(searchBlogById);
        pstm.setInt(1,id);
        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            String header = resultSet.getString("header");
            String content = resultSet.getString("content");
            String author = resultSet.getString("author");
            Timestamp date = resultSet.getTimestamp("date");
            int category_id = resultSet.getInt("category_id");
            blog = new Blog(id,header,content,author,date,category_id);
        }
        return blog;
    }

    @Override
    public List<Blog> selectAllBlogApproved() throws SQLException {
        List<Blog> blogApprovedList = new ArrayList<>();
        String getAllBlogApproved = "call getAllBlogApproved(?)";
        CallableStatement statement = connection.prepareCall(getAllBlogApproved);
        statement.setInt(1,1);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String header = resultSet.getString("header");
            String author = resultSet.getString("author");
            Timestamp date = resultSet.getTimestamp("date");
            int category_id = resultSet.getInt("category_id");
            String censor = resultSet.getString("censor");
            int status = resultSet.getInt("status");
            blogApprovedList.add(new Blog(id,header,author,date,category_id,censor,status));
        }
        return blogApprovedList;
    }

    @Override
    public List<Blog> selectAllBlogIsPending() throws SQLException {
        List<Blog> blogIsPendingList = new ArrayList<>();
        String getAllBlogIsPending = "select * from blogs status like = ?";
        PreparedStatement pstm = connection.prepareStatement(getAllBlogIsPending);
        pstm.setInt(1,0);
        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            String header = resultSet.getString("header");
            String author = resultSet.getString("author");
            Timestamp date = resultSet.getTimestamp("date");
            int category_id = resultSet.getInt("category_id");
            int status = resultSet.getInt("status");
            blogIsPendingList.add(new Blog(header,author,date,category_id,status));
        }
        return blogIsPendingList;
    }

    @Override
    public boolean deleteBlog(int id) {
        return false;
    }

    @Override
    public void updateBlog(Blog blog) throws SQLException {
        String updateBlog = "update blogs set header = ?,content=?,date=?,category_id=? where id=?;";
        PreparedStatement pstm = connection.prepareStatement(updateBlog);
        pstm.setString(1,blog.getHeader());
        pstm.setString(2,blog.getContent());
        pstm.setTimestamp(3,blog.getDate());
        pstm.setInt(4,blog.getCategory_id());
        pstm.setInt(5,blog.getId());
        pstm.execute();
    }
}
