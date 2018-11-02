package com.quintus_software.cmput301f18t05.healthcarer;

import android.location.Location;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class test_ProblemClass {
    @Test
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
    public void test_addRecord() {
        Calendar currentTime = Calendar.getInstance();
        Location location = new Location("dummyprovider");
        Problem testProblem = new Problem("Problem1", currentTime, "Derp", "Real", "FINAL");
        Record testRecord = new Record("Record", currentTime, location, "comments", "grave");

        testProblem.addRecord(testRecord);
        assertEquals(testRecord, testProblem.getRecordList().get(0));
    }
}
