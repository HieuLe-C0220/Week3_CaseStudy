package service.blog;

import model.Blog;

import java.util.List;

public class BlogDAO implements IBlogDAO {
    private static final String INSERT_BLOG_SQL = "INSERT INTO blogs"+"(header,content,author,category_id,censor)VALUES"+"(?,?,?)";
    private static final String SELECT_BLOG_BY_HEADER = "SELECT header,content,author,category_id FROM blogs WHERE ";
    private static final String SELECT_ALL_BLOG = "INSERT INTO blogs"+"(header,content,author,category_id,censor)VALUES"+"(?,?,?)";
    private static final String DELETE_BLOG_SQL = "INSERT INTO blogs"+"(header,content,author,category_id,censor)VALUES"+"(?,?,?)";
    private static final String UPDATE_BLOG_SQL = "INSERT INTO blogs"+"(header,content,author,category_id,censor)VALUES"+"(?,?,?)";
    public BlogDAO(){
    }
    @Override
    public void insertBlog(Blog blog) {

    }

    @Override
    public Blog selectBlog(int id) {
        return null;
    }

    @Override
    public List<Blog> selectAllBlog() {
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
