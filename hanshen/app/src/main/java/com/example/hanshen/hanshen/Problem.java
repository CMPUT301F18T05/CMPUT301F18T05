package com.example.hanshen.hanshen;


import java.text.SimpleDateFormat;
import java.util.Date;


public class Problem {

    private Date date;
    private String description;
    //private static final Integer max_chars = 100;
    //private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-ddThh:mm:ss");
    private String title;

    Problem(){
        this.date = new Date();
        this.description = "";
        this.title = "None";
    }
    Problem(String description, String title){
        this.date = new Date();
        this.description = description;
        this.title = title;
    }
    public void setTitle(String newTitle){
        this.title = newTitle;
    }
    public void setDate(Date newDate){
        this.date = newDate;
    }
    public void setDescription(String newDescription){
        this.description = newDescription;
    }
    public Date getDate(){
        return this.date;
    }
    public String getTitle() {
        return this.title;
    }
    public String getDescription(){
        return this.description;
    }


    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        return "Title: "+this.title+"\nDescription: "+this.description+"\nTime: "+dateFormat.format(this.date);
    }
}

