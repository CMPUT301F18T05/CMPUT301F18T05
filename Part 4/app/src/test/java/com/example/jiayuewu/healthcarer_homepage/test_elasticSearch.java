package com.example.jiayuewu.healthcarer_homepage;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import android.widget.ArrayAdapter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    /* This test checks if you can post and retrieve a record. */
    public void test_getRecord() {
        Calendar currentTime = Calendar.getInstance();
        Location location = new Location("dummyprovider");
        Record testRecord1 = new Record(21386798, 234324, "Finger", currentTime,
                location, "oww");
        Record testRecord2 = new Record();
        Integer x = 23424;
        ArrayList<Record> recordList;

        //Uploads record online.
        elasticSearch.AddRecordTask addTweetsTask
                = new elasticSearch.AddRecordTask();
        addTweetsTask.execute(testRecord1);

        //Get record from elastic search.
        elasticSearch.GetRecordsTask getRecordTask
                = new elasticSearch.GetRecordsTask();
        getRecordTask.execute(x);

        try {
            recordList = getRecordTask.get();
            testRecord2 = recordList.get(0);
        } catch (Exception e) {
            Log.i("Broke", "Code OOPS");
            assertTrue(Boolean.FALSE);
        }

        assertEquals("21386798", "" + testRecord2.getProblemID());
        assertEquals("234324", "" + testRecord2.getRecordID());
        assertEquals("Finger", "" + testRecord2.getTitle());
    }

    @Test
    /* This test check if you can add a record to a problem. */
    public void test_addRecord() {

    }

}
