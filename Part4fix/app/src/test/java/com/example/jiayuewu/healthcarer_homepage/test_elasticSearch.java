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

    @Test
    /* This test checks if you can post and retrieve a record. */
    public void test_getProblem() {
        Calendar currentTime = Calendar.getInstance();
        Location location = new Location("dummyprovider");
        Problem problem1 = new Problem(21386798, 234324, "Finger", "2018", "ASD", "ASD");
        Problem problem2 = new Problem();
        Integer x = 21386798;
        ArrayList<Problem> recordList;

        //Uploads record online.
        elasticSearch.addProblemTask addTweetsTask
                = new elasticSearch.addProblemTask();
        addTweetsTask.execute(problem1);

        //Get record from elastic search.
        elasticSearch.getProblemsTask getProblemTask
                = new elasticSearch.getProblemsTask();
        getProblemTask.execute(x);

        try {
            recordList = getProblemTask.get();
            problem2 = recordList.get(0);
        } catch (Exception e) {
            Log.i("Broke", "Code OOPS");
//            assertTrue(Boolean.FALSE);
        }

        assertEquals("2018", "" + problem2.getCalenderDate());
        assertEquals("234324", "" + problem2.getProblemID());
        assertEquals("Finger", "" + problem2.getTitle());
    }

    @Test
    /* This test checks if you can post and retrieve a record. */
    public void test_getRecord() {
        Calendar currentTime = Calendar.getInstance();
        Location location = new Location("dummyprovider");
        Record testRecord1 = new Record(21386798, 234324, "Finger", currentTime,
                location, "oww");
        Record testRecord2 = new Record();
        Integer x = 21386798;
        ArrayList<Record> recordList;

        //Uploads record online.
        elasticSearch.addRecordTask addTweetsTask
                = new elasticSearch.addRecordTask();
        addTweetsTask.execute(testRecord1);

        //Get record from elastic search.
        elasticSearch.getRecordsTask getRecordTask
                = new elasticSearch.getRecordsTask();
        getRecordTask.execute(testRecord1.getProblemID());

        try {
            recordList = getRecordTask.get();
            testRecord2 = recordList.get(0);
            Log.i("ASDSADAS", "" + testRecord2 + testRecord2.getTitle());
        } catch (Exception e) {
            Log.i("Broke", "Code OOPS");
//            assertTrue(Boolean.FALSE);
        }

        assertEquals("21386798", "" + testRecord2.getProblemID());
        assertEquals("234324", "" + testRecord2.getRecordID());
        assertEquals("Finger", "" + testRecord2.getTitle());
    }

    @Test
    public void test_getUser() {
        User user1 = new User(21386798, "ASD", "Finger", "ASD", "sad");
        User user2 = new User();
        Integer x = 21386798;
        ArrayList<User> recordList;

        //Uploads record online.
        elasticSearch.addUserTask addTweetsTask
                = new elasticSearch.addUserTask();
        addTweetsTask.execute(user1);

        //Get record from elastic search.
        elasticSearch.getUserTask getProblemTask
                = new elasticSearch.getUserTask();
        getProblemTask.execute(x);

        try {
            recordList = getProblemTask.get();
            user2 = recordList.get(0);
        } catch (Exception e) {
            Log.i("Broke", "Code OOPS");
//            assertTrue(Boolean.FALSE);
        }

        assertEquals("Finger", "" + user2.getEmail());
        assertEquals("ASD", "" + user2.getPhoneNumber());
        assertEquals("sad", "" + user2.getRole());
    }



}
