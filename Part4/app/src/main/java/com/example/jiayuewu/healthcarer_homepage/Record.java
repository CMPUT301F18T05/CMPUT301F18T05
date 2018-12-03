/**
 * Record
 *User can add title description data and comments.
 * user can add location(doesn't be implement)
 *
 * @author: CMPUT301F18T05
 * @since: 1.0
 *
 * Copyright 2018 HSC
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.example.jiayuewu.healthcarer_homepage;


import android.graphics.Bitmap;
import android.location.Location;
import java.util.ArrayList;
import java.util.Calendar;

public class Record {
    private Integer userID;
    private Integer problemID;
    private Integer recordID;
    private String title;
    private String date;
    private Location location;
    private String comment;

    Record() {

    }

    Record(Integer userID, Integer problemID, Integer recordID, String title, String date, String comment) {
        this.userID = userID;
        this.problemID = problemID;
        this.recordID = recordID;
        this.title = title;
        this.date = date;
        this.comment = comment;
    }

    public Integer getProblemID() { return this.problemID; }

    public void setProblemID(Integer problemID) { this.problemID = problemID; }

    public Integer getRecordID() { return this.recordID; }

    public void setRecordID(Integer recordID) { this.recordID = recordID; }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) throws exception_titleTooLong{
        if (title.length() <= 30) {
            this.title = title;
        } else {
            throw new exception_titleTooLong();
        }
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return this.location;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) throws exception_description_too_long{
        if (comment.length() <= 300) {
            this.comment = comment;
        } else {
            throw new exception_description_too_long();
        }
    }

    public Integer getUserID() {
        return this.userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @Override
    public String toString(){
        return this.recordID + " " + this.title + " " + this.date;
    }
}
