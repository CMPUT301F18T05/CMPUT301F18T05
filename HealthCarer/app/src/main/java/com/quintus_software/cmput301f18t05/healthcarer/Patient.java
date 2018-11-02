package com.quintus_software.cmput301f18t05.healthcarer;

import java.util.ArrayList;

public class Patient {
    private String userID;
    private String name;
    private String email;
    private String phoneNumber;
    private String role;
    private String body;
    private ArrayList<Problem> problemList  = new ArrayList<Problem>();

    Patient() {

    }

    Patient(String userID, String name, String email, String phoneNumber, String role,
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

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getRole() {
        return this.role;
    }

    public String getBody() {
        return this.body;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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

    public void setRole(String role) {
        this.role = role;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Problem getProblem(Integer index) {
        return this.problemList.get(index);
    }

    public void addProblem(Problem problem) {
        this.problemList.add(problem);
    }

    public void deleteProblem(Integer index) {
        this.problemList.remove(index);
    }

    public ArrayList<Problem> getProblemList() {
        return this.problemList;
    }

}

