package service.blog;

import model.Blog;

import java.util.List;

public interface IBlogDAO {
    void insertBlog(Blog blog);
    Blog selectBlog(int id);
    List<Blog> selectAllBlog();
    boolean deleteBlog(int id);
    boolean updateBlog(Blog blog);
}
