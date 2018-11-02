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
        return this.userID;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public Integer getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getRole() {
        return this.role;
    }

    public String getBody() {
        return this.body;
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

    public Problem getProblem(Integer index) {
        return this.problemList.get(index);
    }

    public void addProblem(Problem problem) {
        this.problemList.add(problem);
    }
}

