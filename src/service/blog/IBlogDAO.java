package service.blog;

import model.Blog;

import java.sql.SQLException;
import java.util.List;

public interface IBlogDAO {
    void insertBlog(Blog blog) throws SQLException;
    List<Blog> selectBlogByNickName(String nickName) throws SQLException;
    Blog selectBlogById(int id) throws SQLException;
    List<Blog> selectAllBlogApproved() throws SQLException;
    List<Blog> selectAllBlogIsPending() throws SQLException;
    boolean deleteBlog(int id);
    void updateBlog(Blog blog) throws SQLException;
}
