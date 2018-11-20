package com.example.jiayuewu.healthcarer_homepage;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Calendar;

public class test_elasticSearch {


    public void test_get() {
        elasticSearch.GetProblemsTask getTweetsTask =
                new elasticSearch.GetProblemsTask();

        Integer userID = 1;
        getTweetsTask.execute(userID);

        try {
            Log.w("Got", "think");
            ArrayList<Problem> list = getTweetsTask.get();
            Log.w("GOT", ""+ list);

        } catch (Exception e) {
            Log.w("You failed", "D");
        }
    }


    public void test_getProblem() {
        Doctor_Comment dc = new Doctor_Comment(123,123,"ASD",
                "ASD",Calendar.getInstance(), "ASD");

        elasticSearch.addDoctorCommentTask addTweetsTask
                = new elasticSearch.addDoctorCommentTask();
        addTweetsTask.execute(dc);
    }


}
