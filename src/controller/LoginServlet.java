package controller;

import model.User;
import service.user.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private final UserDAO userDAO = UserDAO.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nickName = request.getParameter("nickName");
        String password = request.getParameter("password");
        User user;
        try {
            user = userDAO.checkUser(nickName,password);
            int permission_admin = 1;
            int permission_QTV = 2;
            if (user != null) {
                if (user.getPermission_Id()==permission_admin || user.getPermission_Id() == permission_QTV) {
                    request.setAttribute("nickName",user);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/homePageAdmin.jsp");
                    requestDispatcher.forward(request,response);
                } else {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("view/homePageUser.jsp");
                    dispatcher.forward(request,response);
                }
            } else {
                request.setAttribute("mess","Tài khoản không chính xác!!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("view/login.jsp");
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
