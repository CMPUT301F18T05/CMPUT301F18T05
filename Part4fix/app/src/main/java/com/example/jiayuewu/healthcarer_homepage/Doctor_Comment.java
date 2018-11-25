/**
 * add_doctor_comment class
 *Doctor can add comment for their patient prolblems

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
        if (title.length() <= 30) {
            this.title = title;
        } else {
            this.title = "";
        }
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
        if (comment.length() <= 300) {
            this.comment = comment;
        } else {
            this.comment = "";
        }
    }
}
