package service.user;

import model.User;
import service.DBConnection;
import service.login.CheckUser;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private Connection connection;
    private static UserDAO instance;
    public UserDAO() throws SQLException, ClassNotFoundException {
        this.connection = DBConnection.getConnection();
    }
    public static UserDAO getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }
    @Override
    public User checkUser(String nickName,String password) throws SQLException {
        List<User> userList = new ArrayList<>();
        String getAllUser = "call getAllUser()";
        CallableStatement statement = connection.prepareCall(getAllUser);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String user = resultSet.getString("nickName");
            String pass = resultSet.getString("password");
            int permission_Id = resultSet.getInt("permission_Id");
            User user1 = new User(user,pass,permission_Id);
            userList.add(user1);
        }
        return CheckUser.checkUser(nickName,password,userList);
    }

    @Override
    public void insertUser(User user) throws SQLException {
        String addUser = "call addUser(?,?,?,?,?)";
        CallableStatement statement = connection.prepareCall(addUser);
        statement.setString(1,user.getFirstName());
        statement.setString(2,user.getLastName());
        statement.setString(3,user.getAddress());
        statement.setString(4,user.getNickName());
        statement.setString(5,user.getPassWord());
        statement.execute();
    }

    @Override
    public User showUserByNickName(String nickName) throws SQLException {
        User user = null;
        String searchUser = "call searchUserByNickName(?)";
        CallableStatement statement = connection.prepareCall(searchUser);
        statement.setString(1,nickName);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String firstName = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            String address = resultSet.getString(4);
            String nickName1 = resultSet.getString(5);
            String password = resultSet.getString(6);
            int permission_id = resultSet.getInt(7);
            user = new User(id,firstName,lastName,address,nickName1,password,permission_id);
        }
        return user;
    }

    @Override
    public List<User> selectAllUser() {
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public boolean updateUser(User blog) {
        return false;
    }
}
