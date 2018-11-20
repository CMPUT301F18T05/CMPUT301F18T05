package com.example.jiayuewu.healthcarer_homepage;

public class DataHolder {
    private static User data;
    public static User getData() {return data;}
    public static void setData(User data) {DataHolder.data = data;}
}