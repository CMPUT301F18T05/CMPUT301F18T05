package com.example.jiayuewu.healthcarer_homepage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Record {
    private String title;
    private Date date;
    private String description;
    //private static final Integer max_chars = 100;
    //private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-ddThh:mm:ss");


    Record(){
        this.title = "None";
        this.date = new Date();
        this.description = "";

    }
    Record(String title, String description){
        this.title = title;
        this.date = new Date();
        this.description = description;

    }
    public void setTitle(String newTitle){
        this.title = newTitle;
    }
    public String getTitle() {
        return this.title;
    }

    public void setDate(Date newDate){
        this.date = newDate;
    }
    public Date getDate(){
        return this.date;
    }

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String newDescription){
        this.description = newDescription;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        return "Title: "+this.title+"\nDescription: "+this.description+"\nDate started: "+dateFormat.format(this.date);
    }
}

