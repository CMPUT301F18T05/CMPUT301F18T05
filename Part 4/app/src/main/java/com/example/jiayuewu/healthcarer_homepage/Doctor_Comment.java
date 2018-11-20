package com.example.jiayuewu.healthcarer_homepage;


import java.util.Calendar;

public class Doctor_Comment {
    private Integer problemID;
    private Integer doctorCommentID;
    private String title;
    private String name;
    private Calendar date;
    private String comment;

    Doctor_Comment(){

    }

    Doctor_Comment(Integer problemID, Integer doctorCommentID, String title, String name, Calendar date, String comment){
        this.problemID = problemID;
        this.doctorCommentID = doctorCommentID;
        this.title = title;
        this.name = name;
        this.date = date;
        this.comment = comment;
    }

    public Integer getDoctorCommentID() { return this.doctorCommentID; }

    public void setDoctorCommentID(Integer doctorCommentID) { this.doctorCommentID = doctorCommentID; }

    public Integer getProblemID() { return this.problemID; }

    public void setProblemID(Integer problemID) { this.problemID = problemID; }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDate() {
        return this.date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
