package com.quintus_software.cmput301f18t05.healthcarer;

import java.util.Calendar;

import java.util.ArrayList;
import java.util.Date;

public class Problem {
    private String title;
    private Calendar calenderDate;
    private String description;
    private String type;
    private ArrayList<Record> recordList  = new ArrayList<Record>();
    private String bodyPart;

    Problem() {

    }

    Problem(String title, Calendar calenderDate, String description, String type, String bodyPart) {

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
        return this.calenderDate;
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

    public void addRecord(Record record) {
        this.recordList.add(record);
    }

}
