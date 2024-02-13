package com.service.login.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CryptoInfo {

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public CryptoInfo(BCryptPasswordEncoder passwordEncoder){
        this.passwordEncoder=passwordEncoder;
    }

    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean matchesPassword(String password, String passwordCodify){
    return passwordEncoder.matches(password, passwordCodify);
    }


}
