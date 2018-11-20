package com.example.jiayuewu.healthcarer_homepage;

import android.location.Location;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test
    /* Testing is to make sure that a title less than or equal to 30 characters is permissible*/
    public void test_titleLengthMaximum() {
        Record testRecord = new Record();
        Boolean failedTest = Boolean.FALSE;
        String failString = new String();

        for (Integer i = 0; i < 30; i++) {
            failString += "E";
        }

        // Idea here is to test setting a below the minimum required characters. (This should throw
        // an exception. The try statement is because Junit3 doesn't assertNotException (Junit4 can))
        try {
            testRecord.setTitle(failString);
        } catch(Exception e) {
            failedTest = Boolean.TRUE;
        }

        assertTrue(failedTest);

        Calendar currentTime = Calendar.getInstance();
        Problem testProblem2 = new Problem("Problem1", currentTime, "Derp", "Real", "FINAL");

        // Test to make sure that the length is less than 30 characters long.
        assertTrue(testProblem2.getTitle().length() <= 30);

    }


    @Test
    /* Test to make sure that the comment is not longer than 300 characters. */
    public void test_commentDescriptionMaximum() {
        Problem testProblem = new Problem();
        Boolean failedTest = Boolean.FALSE;
        String failString = new String();

        for (Integer i = 0; i < 301; i++) {
            failString += "D";
        }

        try {
            testProblem.setDescription(failString);
        } catch (Exception e) {
            failedTest = Boolean.TRUE;
        }

        Calendar currentTime = Calendar.getInstance();
        Problem testProblem2 = new Problem("Problem1", currentTime, "Derp", "Real", "FINAL");


        // Test to make sure that the description length is not longer than 300 characters.
        assertTrue(testProblem2.getDescription().length() <= 300);

    }


}
