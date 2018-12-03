/**
 * Problem
 *
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


import java.util.Calendar;

import java.util.ArrayList;
import java.util.Date;

public class Problem {
    private Integer problemID;
    private Integer userID;
    private String title;
    private String calenderDate;
    private String description;
//    private String bodyPart;

    Problem() {

    }

//    Problem(Integer userID, Integer problemID, String title, String calenderDate, String description, String bodyPart) {

    Problem(Integer userID, Integer problemID, String title, String calenderDate, String description) {
        this.problemID = problemID;
        this.userID = userID;
        this.title = title;
        this.calenderDate = calenderDate;
        this.description = description;
//        this.bodyPart = bodyPart;
    }

    public Integer getUserID() {
        return this.userID;
    }

    public void setUserID(Integer userID) {

        this.userID = userID;
    }

    public Integer getProblemID() { return this.problemID; }

    public void setProblemID(Integer problemID) { this.problemID = problemID; }

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

    public String getCalenderDate() {
        return this.calenderDate;
    }

    public void setCalenderDate(String calenderDate) {
        this.calenderDate = calenderDate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) throws exception_description_too_long {
        if (description.length() <= 300) {
            this.description = description;
        } else {
            throw new exception_description_too_long();
        }
    }

//    public String getBodyPart() {
//        return this.bodyPart;
//    }
//
//    public void setBodyPart(String bodyPart) {
//        this.bodyPart = bodyPart;
//    }

    @Override
    public String toString(){
        return this.problemID + " | " + this.title + " | " + this.calenderDate;
    }

}
