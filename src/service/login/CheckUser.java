package service.login;

import model.User;

import java.util.List;

public class CheckUser {
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
}
