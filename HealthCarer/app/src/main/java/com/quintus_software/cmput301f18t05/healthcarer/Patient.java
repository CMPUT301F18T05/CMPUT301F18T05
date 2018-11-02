package com.quintus_software.cmput301f18t05.healthcarer;

import java.util.ArrayList;

public class Patient {
    private String userID;
    private String name;
    private String email;
    private Integer phoneNumber;
    private String role;
    private String body;
    private ArrayList<Problem> problemList  = new ArrayList<Problem>();

    Patient(String userID, String name, String email, Integer phoneNumber, String role,
            String body) {

    }

    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public String getBody() {
        return body;
    }

    public void setUserID(String userID) {
        this.setUserID(userID);
    }

    public void setName(String name) {
        this.setName(name);
    }

    public void setEmail(String email) {
        this.setEmail(email);
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.setPhoneNumber(phoneNumber);
    }

    public void setRole(String role) {
        this.setRole(role);
    }

    public void setBody(String body) {
        this.setBody(body);
    }

    public Problem getProblemList(Integer index) {
        return this.problemList.get(index);
    }

    public void setProblemList(ArrayList<Problem> problemList) {
        this.problemList = problemList;
    }
}

