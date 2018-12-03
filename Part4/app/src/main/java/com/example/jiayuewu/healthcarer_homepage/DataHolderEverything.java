package com.example.jiayuewu.healthcarer_homepage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DataHolderEverything {
    private static User data;
    private static ArrayList<Problem> problemList;
    private static ArrayList<Record> recordList;
    private static ArrayList<photo_object> photoList;

    public static User getData() {return data;}
    public static void setData(User data) {DataHolderEverything.data = data;}

    public static ArrayList<Problem> getProblemList() {
        return DataHolderEverything.problemList;
    }

    public static void setProblemList(ArrayList<Problem> problemList) {
        DataHolderEverything.problemList = problemList;
    }

    public static ArrayList<Record> getRecordList() {
        return DataHolderEverything.recordList;
    }

    public static void setRecordList(ArrayList<Record> recordList) {
        DataHolderEverything.recordList = recordList;
    }

    public static ArrayList<photo_object> getPhotoList() {
        return DataHolderEverything.photoList;
    }

    public static void setPhotoList(ArrayList<photo_object> photoList) {
        DataHolderEverything.photoList = photoList;
    }
}
