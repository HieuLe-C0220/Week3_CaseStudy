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

@WebServlet(name = "AdminServlet",urlPatterns = "/adminPage")
public class AdminServlet extends HttpServlet {
    private final BlogDAO blogDAO = BlogDAO.getInstance();
    private final UserDAO userDAO = UserDAO.getInstance();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        String nickName = request.getParameter("nickName");
        if (action == null) {
            action = "";
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
                case "blogList":
                    showBlogList(request,response,nickName);
                    break;
                case "editBlog":
                    showEditBlog(request,response,nickName);
                    break;
                default:
                    showInterface(request,response,nickName);
                    break;
//            case "selectBlog":
//                searchBlogByName(request,response);
//                break;
//            case "blogWait":
//                showBlogIsPending(request,response);
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
        response.setContentType("text/html;charset=UTF-8");
    }

    private void showInterface(HttpServletRequest request, HttpServletResponse response, String nickName) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/homePageAdmin.jsp");
        dispatcher.forward(request,response);
    }

    private void showBlogList(HttpServletRequest request, HttpServletResponse response, String nickName) throws ServletException, IOException, SQLException {
        List<Blog> blogList = blogDAO.selectAllBlogApproved();
        request.setAttribute("blogList",blogList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/adminView/blogList.jsp");
        dispatcher.forward(request,response);
    }
    private void showEditBlog(HttpServletRequest request, HttpServletResponse response, String nickName) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Blog existingBlog = blogDAO.selectBlog(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/adminView/editBlog.jsp");
        request.setAttribute("blog",existingBlog);
        dispatcher.forward(request,response);
    }
}
