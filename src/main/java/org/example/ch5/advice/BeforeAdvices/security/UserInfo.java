package org.example.ch5.advice.BeforeAdvices.security;

//класс хнарящий имя пользователя и пароль
public class UserInfo {

    private String userName;
    private String password;

    public UserInfo(String name, String password){
        this.password = password;
        this.userName = name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
