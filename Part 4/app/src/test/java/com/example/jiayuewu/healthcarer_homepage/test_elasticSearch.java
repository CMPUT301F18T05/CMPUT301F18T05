package com.example.jiayuewu.healthcarer_homepage;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

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



}
