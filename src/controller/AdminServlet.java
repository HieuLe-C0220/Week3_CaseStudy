package controller;

import model.Blog;
import model.User;
import service.blog.BlogDAO;
import service.user.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminServlet",urlPatterns = "/adminPage")
public class AdminServlet extends HttpServlet {
    private final BlogDAO blogDAO = BlogDAO.getInstance();
    private final UserDAO userDAO = UserDAO.getInstance();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "postBlog":
                    postBlog(request,response);
                    break;
                case "browsePosts":
                    browsePost(request,response);
                case "editBlog":
                    editBlog(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "blogList":
                    showBlogList(request,response);
                    break;
                case "postBlog":
                    showNewFormBlog(request,response);
                    break;
                case "editBlog":
                    showEditBlog(request,response);
                    break;
                case "blogWait":
                    showBlogIsPending(request,response);
                    break;
                case "readBlog":
                    readBlog(request,response);
                case "readEditBlog":
                    readEditBlog(request,response);
                case "deleteBlog":
                    deleteBlog(request,response);
                default:
                    showInterface(request,response);
                    break;
//            case "selectBlog":
//                searchBlogByName(request,response);
//                break;

//            case "userList":
//                showUserList(request,response);
//                break;
//            case "userSearch":
//                searchUserByNickName(request,response);
//                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
    }

    private void deleteBlog(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        blogDAO.deleteBlog(id);
        List<Blog> blogList = blogDAO.selectAllBlogApproved();
        request.setAttribute("blogList",blogList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/adminView/blogList.jsp");
        dispatcher.forward(request,response);
    }

    private void readEditBlog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/readEditBlog.jsp");
        dispatcher.forward(request,response);
    }
    private void readBlog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/readBlog.jsp");
        dispatcher.forward(request,response);
    }

    private void showBlogIsPending(HttpServletRequest request, HttpServletResponse response) {

    }
    private void editBlog(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String header = request.getParameter("header");
        String content = request.getParameter("content");
        String nickName = request.getParameter("author");
        long millis1 =  new java.util.Date().getTime();
        java.sql.Timestamp ts = new java.sql.Timestamp(millis1);
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        Blog blog = new Blog(id,header,content,ts,category_id);
        blogDAO.updateBlog(blog);
        request.setAttribute("blogEdit",blogDAO.selectBlogById(id));
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/readEditBlog.jsp");
        dispatcher.forward(request,response);
    }
    private void postBlog(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String header = request.getParameter("header");
        String content = request.getParameter("content");
        String nickName = request.getParameter("user");
        long millis1 = new java.util.Date().getTime();
        java.sql.Timestamp date = new java.sql.Timestamp(millis1);
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        String censor = request.getParameter("user");
        int status = 1;
        Blog blog = new Blog(header,content,nickName,date,category_id,censor,status);
        blogDAO.insertBlogByAdmin(blog);
        User user = new User(nickName);
        request.setAttribute("nickName",user);
        request.setAttribute("mess","Blog was added");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/blogPost.jsp");
        dispatcher.forward(request,response);
    }

    private void browsePost(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showInterface(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/homePageAdmin.jsp");
        dispatcher.forward(request,response);
    }

    private void showBlogList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Blog> blogApprovedList = blogDAO.selectAllBlogApproved();
        request.setAttribute("blogApprovedList",blogApprovedList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/adminView/blogList.jsp");
        dispatcher.forward(request,response);
    }
    private void showEditBlog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Blog existingBlog = blogDAO.selectBlogById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/adminView/editBlog.jsp");
        request.setAttribute("blog",existingBlog);
        dispatcher.forward(request,response);
    }
    private void showNewFormBlog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nickName = request.getParameter("user");
        request.setAttribute("nickName",nickName);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/blogPost.jsp");
        dispatcher.forward(request,response);
    }
}
