package com.example.jiayuewu.healthcarer_homepage;


import java.util.ArrayList;

public class User {
    private Integer userID;
    private String name;
    private String email;
    private String phoneNumber;
    private String role;

    User() {

    }


    public Integer getUserID() {
        return this.userID;
    }

    public void setUserID(Integer userID) {

        this.userID = userID;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

}
