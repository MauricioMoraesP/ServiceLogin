package com.service.login.demo.dao;


import com.service.login.demo.entity.User;

public interface LoginDAO {
void createLogin(User usuario);
User logar(String userName, String password);

}
