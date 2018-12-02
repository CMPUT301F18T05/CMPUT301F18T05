package com.example.jiayuewu.healthcarer_homepage;

import android.graphics.Bitmap;

public class photo_object {
    private Bitmap bitmap;
    private Integer recordID;
    private Integer photoID;
    private String labelName;
    private String bodyPart;

    photo_object() {
    }

    photo_object(Integer recordID, Integer photoID, Bitmap bitmap, String labelName, String bodypart) {
        this.setRecordID(recordID);
        this.setPhotoID(photoID);
        this.setBitmap(bitmap);
        this.setLabelName(labelName);
        this.setBodyPart(bodypart);
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
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
}
