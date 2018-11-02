package com.quintus_software.cmput301f18t05.healthcarer;

import android.icu.util.Calendar;

import java.util.ArrayList;
import java.util.Date;

public class Problem {
    private String title;
    private Calendar calenderDate;
    private String description;
    private String type;
    private ArrayList<Record> recordList  = new ArrayList<Record>();
    private String bodyPart;

    Problem(String title, Date calenderDate, String description, String type, String bodyPart) {

    }

    public Calendar getDate(){
        return this.getCalenderDate();
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Calendar getCalenderDate() {
        return calenderDate;
    }

    public void setCalenderDate(Calendar calenderDate) {
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

    public ArrayList<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(ArrayList<Record> recordList) {
        this.recordList = recordList;
    }
}
