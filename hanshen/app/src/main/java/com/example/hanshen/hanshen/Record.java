package com.example.hanshen.hanshen;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Record {
    private String title;
    private Date date;
    private String comment;
    //private static final Integer max_chars = 100;
    //private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-ddThh:mm:ss");

    Record(){
        this.date = new Date();
        this.title = "";
        this.comment = "None";
    }
    Record(String title, String comment){
        this.date = new Date();
        this.title = title;
        this.comment = comment;
    }
    public void setTitle(String newTitle){
        this.title = newTitle;
    }
    public void setDate(Date newDate){
        this.date = newDate;
    }
    public void setDescription(String newComment){
        this.comment = newComment;
    }
    public String getTitle() {
        return this.title;
    }
    public Date getDate(){
        return this.date;
    }
    public String getDescription(){
        return this.comment;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        return "title: " + this.title + "\ndate started: " + dateFormat.format(this.date) + "\nbrief description: "+this.comment;
    }
}
