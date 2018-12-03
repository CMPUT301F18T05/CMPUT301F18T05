package com.example.jiayuewu.healthcarer_homepage;

import android.graphics.Bitmap;

public class photo_object {
    private String bitmap;
    private Integer userID;
    private Integer recordID;
    private Integer photoID;
    private String labelName;
    private String bodyPart;

    photo_object() {
    }

    photo_object(Integer userID, Integer recordID, Integer photoID, String bitmap, String labelName, String bodypart) {
        this.setRecordID(recordID);
        this.setPhotoID(photoID);
        this.setBitmap(bitmap);
        this.setLabelName(labelName);
        this.setBodyPart(bodypart);
    }

    public String getBitmap() {
        return this.bitmap;
    }

    public void setBitmap(String bitmap) {
        this.bitmap = bitmap;
    }

    public Integer getRecordID() {
        return this.recordID;
    }

    public void setRecordID(Integer recordID) {
        this.recordID = recordID;
    }

    public Integer getPhotoID() {
        return this.photoID;
    }

    public void setPhotoID(Integer photoID) {
        this.photoID = photoID;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getBodyPart() {
        return this.bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
}
