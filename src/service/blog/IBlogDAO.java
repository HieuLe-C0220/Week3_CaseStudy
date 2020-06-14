package service.blog;

import model.Blog;

import java.sql.SQLException;
import java.util.List;

public interface IBlogDAO {
    void insertBlog(Blog blog) throws SQLException;
    List<Blog> selectBlogByNickName(String nickName) throws SQLException;
    Blog selectBlog(int id);
    List<Blog> selectAllBlogApproved() throws SQLException;
    List<Blog> selectAllBlogIsPending();
    boolean deleteBlog(int id);
    boolean updateBlog(Blog blog);
}
