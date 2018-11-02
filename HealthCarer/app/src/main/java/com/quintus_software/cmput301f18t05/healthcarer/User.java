package com.quintus_software.cmput301f18t05.healthcarer;

public abstract class User {
    private String userID;
    private String name;
    private String email;
    private String phoneNumber;

    User() {

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

}
