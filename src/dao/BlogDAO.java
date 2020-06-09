package dao;

import model.Blog;
import model.User;

import java.util.List;

public interface BlogDAO {
    void insertBlog(Blog blog);
    Blog selectBlog(int id);
    List<Blog> selectAllBlog();
    boolean deleteBlog(int id);
    boolean updateBlog(Blog blog);
}
