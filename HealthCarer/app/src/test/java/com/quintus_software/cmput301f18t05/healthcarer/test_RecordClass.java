package com.quintus_software.cmput301f18t05.healthcarer;

import android.location.Location;
import android.media.Image;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class test_RecordClass {
    @Test
    public void test_setRecord() {
        Calendar currentTime = Calendar.getInstance();
        Record testRecord = new Record();
        Location location = new Location("dummyprovider");

        testRecord.setComment("Finger");
        testRecord.setDate(currentTime);
        testRecord.setTitle("Finger hurts.");
        testRecord.setType("Oww");
        testRecord.setLocation(location);

        // It should all pass. (True, True)
        assertEquals(currentTime, testRecord.getDate());
        assertEquals("Finger", testRecord.getComment());
        assertEquals("Finger hurts.", testRecord.getTitle());
        assertEquals("Oww", testRecord.getType());
        assertEquals(location, testRecord.getLocation());
    }

    @Test
    public void test_addImageToRecord() {
        // Make sure make a test for more than 10 photoes.
        Calendar currentTime = Calendar.getInstance();
        Location location = new Location("dummyprovider");

//        Record testRecord = new Record("RecordTitle", )

    }
}
