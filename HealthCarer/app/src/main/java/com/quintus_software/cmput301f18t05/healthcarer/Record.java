package com.quintus_software.cmput301f18t05.healthcarer;

import android.location.Location;
import android.media.Image;

import java.util.ArrayList;
import java.util.Calendar;

public class Record {
    private String title;
    private Calendar date;
    private ArrayList<Image> imageList = new ArrayList<Image>();
    private Location location;
    private String comment;
    private String type;
    private ArrayList<Doctor_Comment> doctorComentList = new ArrayList<Doctor_Comment>();

    Record(String title, Calendar date, Location location, String comment, String type) {

    }

    public void addDoctorComment(Doctor_Comment doctor_comment){
        this.doctorComentList.add(doctor_comment);
    }

    public Doctor_Comment getDoctorComment(Integer index){
        return this.doctorComentList.get(index);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Calendar getDate() {
        return this.date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    // Not sure whether to return imageList or specific image.
//    public ArrayList<Image> getImageList() {
//        return imageList;
//    }

    public void addPhoto(Image image) {
        this.imageList.add(image);
    }

    public Image getPhoto(Integer index) {
        return this.imageList.get(index);
    }

    public Location getLocation() {
        return this.location;
    }

    public void deletePhoto(Integer index) {
        this.imageList.remove(index);
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
