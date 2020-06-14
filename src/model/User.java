package model;

public class User {
    private int userID;
    private String firstName;
    private String lastName;
    private String address;
    private String nickName;
    private String passWord;
    private int permission_Id;

    public User(String nickName) {
        this.nickName = nickName;
    }

    public User(String nickName, String passWord) {
        this.nickName = nickName;
        this.passWord = passWord;
    }
    public User(String nickName, String password, int permission_id) {
        this.nickName = nickName;
        this.passWord = password;
        this.permission_Id = permission_id;
    }

    public User(int userID, String nickName, String passWord, int permission_Id) {
        this.userID = userID;
        this.nickName = nickName;
        this.passWord = passWord;
        this.permission_Id = permission_Id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getPermission_Id() {
        return permission_Id;
    }

    public void setPermission_Id(int permission_Id) {
        this.permission_Id = permission_Id;
    }

    public User() {
    }
    public User(String firstName, String lastName, String address, String nickName, String passWord) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.nickName = nickName;
        this.passWord = passWord;
    }

    public User(int userID, String firstName, String lastName, String address, String nickName, String passWord, int permission_Id) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.nickName = nickName;
        this.passWord = passWord;
        this.permission_Id = permission_Id;
    }
}
