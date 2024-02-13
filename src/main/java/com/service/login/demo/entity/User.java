package com.service.login.demo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="userName")
    private String userName;

    @Column(name="password")
    private  String password;

    @Column(name="name")
    private  String name;

    @Column(name="dataNascimento")
    private Date dataNascimento;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUser getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUser tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public boolean isContaVerificada() {
        return contaVerificada;
    }

    public void setContaVerificada(boolean contaVerificada) {
        this.contaVerificada = contaVerificada;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Column(name="tipoUsuario")
    private TipoUser tipoUsuario;

    @Column(name="verificado")
    private boolean contaVerificada;

    public User(String userName, String password, String name, Date dataNascimento) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.dataNascimento = dataNascimento;
    }

    public User() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", tipoUsuario=" + tipoUsuario +
                ", contaVerificada=" + contaVerificada +
                '}';
    }
}
