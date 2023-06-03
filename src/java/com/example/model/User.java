/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author user
 */

public class User {
    private Integer userId;
    private String name;
    private String surname;
    private String login;
    private String passwordHash;

    public User(Integer userId, String name, String surname, String login, String password) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.passwordHash = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
    
    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return passwordHash;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.passwordHash = password;
    }
}

