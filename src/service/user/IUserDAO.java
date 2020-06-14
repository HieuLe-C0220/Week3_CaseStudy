package service.user;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    User checkUser(String nickName,String password) throws SQLException;
    User showUserByNickName(String nickName) throws SQLException;
    List<User> selectAllUser();
    boolean deleteUser(int id);
    boolean updateUser(User user);
}
