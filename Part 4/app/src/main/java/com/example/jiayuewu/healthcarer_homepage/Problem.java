package com.example.jiayuewu.healthcarer_homepage;


import java.util.Calendar;

import java.util.ArrayList;
import java.util.Date;

public class Problem {
    private Integer problemID;
    private Integer userID;
    private String title;
    private Calendar calenderDate;
    private String description;
    private String bodyPart;

    Problem() {

    }

    Problem(Integer userID, Integer problemID, String title, Calendar calenderDate, String description, String bodyPart) {
        this.problemID = problemID;
        this.userID = userID;
        this.title = title;
        this.calenderDate = calenderDate;
        this.description = description;
        this.bodyPart = bodyPart;
    }

    public Integer getUserID() {
        return this.userID;
    }

    public void setUserID(Integer userID) {

        this.userID = userID;
    }

    public Integer getProblemID() { return this.problemID; }

    public void setProblemID(Integer problemID) { this.problemID = problemID; }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Calendar getCalenderDate() {
        return this.calenderDate;
    }

    public void setCalenderDate(Calendar calenderDate) {
        this.calenderDate = calenderDate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBodyPart() {
        return this.bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

}
