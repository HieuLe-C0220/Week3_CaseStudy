package service.login;

import model.User;
import service.DBConnection;

import java.sql.*;
import java.util.List;

public class UserManager {
    private final String INSERT_USER = "INSERT INTO users (firstName,lastName,address,nickName,passwords,permission_Id) " +
            "VALUES (?,?,?,?,?,?);";
    Connection connection = DBConnection.getConnection();

    public static User checkUser(String nickName, String password, List<User> accountUser) {
        User account = null;
        for (User user : accountUser) {
            if (nickName.equalsIgnoreCase(user.getNickName())) {
                if (password.equalsIgnoreCase(user.getPassWord())) {
                    account = user;
                    break;
                }
            }
        }
        return account;
    }
    public boolean signUp(User user){
        try {
            PreparedStatement pstm = connection.prepareStatement(INSERT_USER);
            pstm.setString(1,user.getFirstName());
            pstm.setString(2,user.getLastName());
            pstm.setString(3,user.getAddress());
            pstm.setString(4,user.getNickName());
            pstm.setString(5,user.getPassWord());
            pstm.setInt(6,user.getPermission_Id());
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
