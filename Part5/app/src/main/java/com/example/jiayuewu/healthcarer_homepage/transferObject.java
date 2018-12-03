package com.example.jiayuewu.healthcarer_homepage;

public class transferObject {
    private Integer userID;
    private Integer code;

    transferObject() {}

    transferObject(Integer userID, Integer code) {
        this.userID = userID;
        this.code = code;
    }

    public Integer getUserID() {
        return this.userID;
    }

    public void setUserID(Integer userID){
            this.userID = userID;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code    ){
        this.code = code;
    }

}
