package controller;

import model.Blog;
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

@WebServlet(name = "UserServlet",urlPatterns = "/userPage")
public class UserServlet extends HttpServlet {
    private final BlogDAO blogDAO = BlogDAO.getInstance();
    private final UserDAO userDAO = UserDAO.getInstance();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        String nickName = request.getParameter("nickName");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "postBlog":
                    postBlog(request,response);
                    break;
                default:
                    showInterfaceUser(request,response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String nickName = request.getParameter("nickName");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "postBlog":
                    showNewFormBlog(request,response);
                    break;
                case "selectBlogByMe":
                    showBlogByMe(request,response);
                    break;
                default:
                    showInterfaceUser(request,response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showInterfaceUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/homePageUser.jsp");
        dispatcher.forward(request,response);
    }

    private void showBlogByMe(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String nickName = request.getParameter("nickName");
        List<Blog> listBlogByMe = blogDAO.selectBlogByNickName(nickName);
        request.setAttribute("listBlogByMe",listBlogByMe);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/userView/blogListByMe.jsp");
        dispatcher.forward(request,response);
    }

    private void showNewFormBlog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        User user =
        String nickName = request.getParameter("nickName");
        request.setAttribute("nickName",nickName);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/userView/blogPost.jsp");
        dispatcher.forward(request,response);
    }

    private void postBlog(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String header = request.getParameter("header");
        String content = request.getParameter("content");
        String nickName = request.getParameter("nickName");
        long millis1 = new java.util.Date().getTime();
        java.sql.Timestamp date = new java.sql.Timestamp(millis1);
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        Blog blog = new Blog(header,content,nickName,date,category_id);
        blogDAO.insertBlog(blog);
        request.setAttribute("mess","Blog was added and pending");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/blogPost.jsp");
        dispatcher.forward(request,response);
    }
}
