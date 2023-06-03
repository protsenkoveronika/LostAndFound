/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author user
 */

public class Item {
    private Integer id;
    private String name;
    private String description;
    private String contact;

    public Item(Integer id, String name, String description, String contact) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.contact = contact;
    }
    
    public Integer getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    public String getContact() {
        return contact;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setContact(String contact) {
        this.contact = contact;
    }
}
