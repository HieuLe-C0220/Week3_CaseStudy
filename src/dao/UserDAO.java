package dao;

import model.User;

import java.util.List;

public interface UserDAO {
    void insertUser(User blog);
    User selectUser(int id);
    List<User> selectAllUser();
    boolean deleteUser(int id);
    boolean updateUser(User blog);
}
