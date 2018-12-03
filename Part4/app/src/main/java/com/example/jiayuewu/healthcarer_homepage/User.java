/**
 * User
 *user  information
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


import java.util.ArrayList;

public class User {
    private Integer userID;
    private String name;
    private String email;
    private String phoneNumber;
    private String role;
    private ArrayList<Integer> userList = new ArrayList<Integer>();

    User() {

    }

    User(Integer userID,String name,String email,String phoneNumber, String role) {
        this.userID = userID;
        this.role = role;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    public Integer getUserID() {
        return this.userID;
    }

    public void setUserID(Integer userID) throws Exception_User_ID_Too_Short{
        if (userID.toString().length() >= 8) {
            this.userID = userID;
        } else {
            throw new Exception_User_ID_Too_Short();
        }
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Integer> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<Integer> userList) {
        this.userList = userList;
    }

    public void addUser(Integer userID) {
        this.userList.add(userID);
    }

    public void deleteUser(Integer userID) {
        this.userList.remove(userID);
    }

}
