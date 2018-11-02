package com.quintus_software.cmput301f18t05.healthcarer;

import android.location.Location;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class test_ProblemClass {
    @Test
    /* This problem will check if a problem is created with the proper fields. */
    public void test_setProblem() {
        Calendar currentTime = Calendar.getInstance();
        Problem testProblem = new Problem();

        testProblem.setBodyPart("Finger");
        testProblem.setCalenderDate(currentTime);
        testProblem.setDescription("Finger hurts.");
        testProblem.setTitle("Oww");
        testProblem.setType("Owwy");

        // It should all pass. (True, True)
        assertEquals(currentTime, testProblem.getCalenderDate());
        assertEquals("Oww", testProblem.getTitle());
        assertEquals("Finger hurts.", testProblem.getDescription());
        assertEquals("Owwy", testProblem.getType());
        assertEquals("Finger", testProblem.getBodyPart());
    }

    @Test
    /* This test check if you can add a record to a problem. */
    public void test_addRecord() {
        Calendar currentTime = Calendar.getInstance();
        Location location = new Location("dummyprovider");
        Problem testProblem = new Problem("Problem1", currentTime, "Derp", "Real", "FINAL");
        Record testRecord = new Record("Record", currentTime, location, "comments", "grave");

        testProblem.addRecord(testRecord);
        assertEquals(testRecord, testProblem.getRecordList().get(0));
    }

    @Test
    /* This test checks if the delete function removes the record from the problem. */
    public void test_deleteRecord() {
        Calendar currentTime = Calendar.getInstance();
        Location location = new Location("dummyprovider");
        Problem testProblem = new Problem("Problem1", currentTime, "Derp", "Real", "FINAL");
        Record testRecord1 = new Record("Record", currentTime, location, "comments", "grave");
        Record testRecord2 = new Record("Crap", currentTime, location, "super", "hot");


        testProblem.addRecord(testRecord1);
        testProblem.addRecord(testRecord2);
        testProblem.deleteRecord(0);

        assertEquals(testRecord2, testProblem.getRecordList().get(0));
        assertFalse(testProblem.getRecordList().contains(testRecord1));
    }

    @Test
    /* This test checks if you can retrieve a record. */
    public void test_getRecord() {
        Calendar currentTime = Calendar.getInstance();
        Location location = new Location("dummyprovider");
        Problem testProblem = new Problem("Problem1", currentTime, "Derp", "Real", "FINAL");
        Record testRecord = new Record("Record", currentTime, location, "comments", "grave");

        testProblem.addRecord(testRecord);
        assertEquals(testRecord, testProblem.getRecord(0));
    }

}
