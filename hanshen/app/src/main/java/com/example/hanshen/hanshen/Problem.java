package com.example.hanshen.hanshen;

/**
 * this is the emotion class which record the date of emotion, comment and date
 * all three value can be got and changed
 * toString gives the format value to be show on the screen
 */

import java.text.SimpleDateFormat;
import java.util.Date;


public class Problem {
    private String title;
    private Date date;
    private String description;
    //private static final Integer max_chars = 100;
    //private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-ddThh:mm:ss");


    Problem(){
        this.title = "None";
        this.date = new Date();
        this.description = "";

    }
    Problem(String title, String description){
        this.title = title;
        this.date = new Date();
        this.description = description;

    }

//    ArrayList<ArrayList<Record>> problemArrayList;
//            for (int i = 0; i < 10; i++) {
//        ArrayList<Record> recordArrayList = new ArrayList<Record>();
//        for (int j = 0; j <= 5; j++) {
//            recordArrayList.add(j);
//        }
//        problemArrayList.add(recordArrayList);
//    }
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

