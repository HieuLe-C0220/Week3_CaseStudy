package controller;

import model.User;
import service.user.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserDAO userDAO;
    {
        try {
            userDAO = UserDAO.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nickName = request.getParameter("nickName");
        String password = request.getParameter("password");
        User user = null;
        try {
            user = userDAO.checkUser(nickName,password);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("permission_id",user.getPermission_Id());
                System.out.println(user.getPermission_Id());
                RequestDispatcher dispatcher = request.getRequestDispatcher("view/login.jsp");
                dispatcher.forward(request,response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("");
                dispatcher.forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/login.jsp");
        dispatcher.forward(request,response);
    }
}
