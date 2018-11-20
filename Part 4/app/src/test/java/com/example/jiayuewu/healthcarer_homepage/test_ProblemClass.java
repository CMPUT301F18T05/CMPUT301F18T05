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
        testProblem.setProblemID(123);
        testProblem.setUserID(234);

        // It should all pass. (True, True)
        assertEquals(currentTime, testProblem.getCalenderDate());
        assertEquals("Oww", testProblem.getTitle());
        assertEquals("Finger hurts.", testProblem.getDescription());
        assertEquals("123", "" + testProblem.getProblemID());
        assertEquals("Finger", testProblem.getBodyPart());
        assertEquals("234", "" + testProblem.getUserID());
    }

    @Test
    /* This test checks if the delete function removes the record from the problem. */
    public void test_deleteRecord() {
        Calendar currentTime = Calendar.getInstance();
        Location location = new Location("dummyprovider");
        Problem testProblem = new Problem(121, 123,"Problem1", currentTime, "Real", "FINAL");
        Record testRecord1 = new Record(123, 432, "ASD", currentTime, location, "grave");
        Record testRecord2 = new Record(123, 435, "asd", currentTime, location, "super");


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
        Problem testProblem2 = new Problem(123,123,   "Derp",currentTime,
                "Real", "FINAL");

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
        Problem testProblem2 = new Problem(123, 324, "Problem1",currentTime,
                "Real", "FINAL");

        // Test to make sure that the description length is not longer than 300 characters.
        assertTrue(testProblem2.getDescription().length() <= 300);
    }




}
