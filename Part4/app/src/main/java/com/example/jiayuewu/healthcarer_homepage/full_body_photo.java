package com.example.jiayuewu.healthcarer_homepage;

import android.graphics.Bitmap;

public class full_body_photo {
    private String bitmap;
    private Integer userID;
    private Integer photoID;


    full_body_photo() {
    }

    full_body_photo(Integer userID, Integer photoID, String bitmap) {
        this.setUserID(userID);
        this.setPhotoID(photoID);
        this.setBitmap(bitmap);
    }

    public String getBitmap() {
        return this.bitmap;
    }

    public void setBitmap(String bitmap) {
        this.bitmap = bitmap;
    }

    public Integer getUserID() {
        return this.userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getPhotoID() {
        return this.photoID;
    }

    public void setPhotoID(Integer photoID) {
        this.photoID = photoID;
    }

}
