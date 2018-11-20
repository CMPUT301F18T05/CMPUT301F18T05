package com.example.jiayuewu.healthcarer_homepage;


import java.util.Calendar;

import java.util.ArrayList;
import java.util.Date;

public class Problem {
    private Integer problemID;
    private Integer userID;
    private String title;
    private String calenderDate;
    private String description;
    private String bodyPart;

    Problem() {

    }

    Problem(Integer userID, Integer problemID, String title, String calenderDate, String description, String bodyPart) {
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
        if (title.length() <= 10) {
            this.title = title;
        } else {
            this.title = "";
        }
    }

    public String getCalenderDate() {
        return this.calenderDate;
    }

    public void setCalenderDate(String calenderDate) {
        this.calenderDate = calenderDate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        if (description.length() <= 300) {
            this.description = description;
        } else {
            this.description = "";
        }
    }

    public String getBodyPart() {
        return this.bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    @Override
    public String toString(){
        return this.problemID + this.title;
    }

}
