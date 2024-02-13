package com.service.login.demo.entity;

public class LoginRequest {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "username='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
