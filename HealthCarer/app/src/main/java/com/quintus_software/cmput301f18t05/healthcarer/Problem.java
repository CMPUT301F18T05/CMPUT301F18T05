package com.quintus_software.cmput301f18t05.healthcarer;

import java.util.Date;

public class Problem {
    private String title;
    private Date calenderDate;
    private String description;
    private String type;
//    private ArrayList<Record>;
    private String bodyPart;


    Problem() {

    }

    public Date getDate(){
        return this.getCalenderDate();
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCalenderDate() {
        return calenderDate;
    }

    public void setCalenderDate(Date calenderDate) {
        this.calenderDate = calenderDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }
}
