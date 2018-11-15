package com.example.hanshen.hanshen;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class Problem {

    private String title;
    private Date date;
    private String description;
    //private static final Integer max_chars = 100;
    //private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-ddThh:mm:ss");

    Problem(){
        this.date = new Date();
        this.title = "";
        this.description = "None";
    }
    Problem(String title, String description){
        this.date = new Date();
        Calendar calendar = Calendar.getInstance();
        //this.date = DateFormat.getDateInstance().format(calendar.getTime());
        this.title = title;
        this.description = description;
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
    public String getTitle() {
        return this.title;
    }
    public Date getDate(){
        return this.date;
    }
    public String getDescription(){
        return this.description;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        return "title: " + this.title + "\ndate started: " + dateFormat.format(this.date) + "\nbrief description: "+this.description;
    }
}
