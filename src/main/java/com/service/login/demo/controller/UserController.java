package com.service.login.demo.controller;
import com.service.login.demo.dao.UserLoginImplementsDAO;
import com.service.login.demo.entity.LoginRequest;
import com.service.login.demo.entity.User;
import com.service.login.demo.service.CryptoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class UserController {
    private UserLoginImplementsDAO UserLoginImplementsDAO;
    private CryptoInfo passwordEncoder;


@Autowired
public  UserController(UserLoginImplementsDAO UserLoginImplementsDAO, CryptoInfo passwordEncoder){
    this.UserLoginImplementsDAO=UserLoginImplementsDAO;
    this.passwordEncoder=passwordEncoder;
}

@PostMapping("/logar")
public User logar(@RequestBody LoginRequest login) {
    return  UserLoginImplementsDAO.logar(login.getUserName(), login.getPassword());
}

@PostMapping("/create-login")
public User fazerLogin(@RequestBody User user) {
   UserLoginImplementsDAO.createLogin(user);
    return user;
}




}
