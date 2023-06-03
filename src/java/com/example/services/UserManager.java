/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.services;

import com.example.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */

public class UserManager {
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
        users.add(new User(1, "H", "S", "H", "green"));
        users.add(new User(2, "L", "T", "L", "blue"));
        users.add(new User(3, "N", "H", "N", "orange"));
        users.add(new User(4, "Li", "P", "Li", "red"));
        users.add(new User(5, "Z", "M", "Z", "yellow"));
        
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User findUserByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null; // User not found
    }
    
    public boolean checkPassword(User user, String password) {
        String storedPassword = user.getPassword();
        return storedPassword.equals(password);
    }
    
    public int getLargestUserId() {
        int largestId = 0;
        for (User user : users) {
            if (user.getUserId() > largestId) {
                largestId = user.getUserId();
            }
        }
        return largestId;
    }
}
