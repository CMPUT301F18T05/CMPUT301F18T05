package com.quintus_software.cmput301f18t05.healthcarer;

import android.icu.util.Calendar;

public class Doctor_Comment {
    private String title;
    private String name;
    private Calendar date;
    private String comment;

    Doctor_Comment(String title, String name, Calendar date, String comment){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
