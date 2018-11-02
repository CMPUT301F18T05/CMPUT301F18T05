package com.quintus_software.cmput301f18t05.healthcarer;

import android.location.Location;
import android.media.Image;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class test_RecordClass {

    @Test
    /* This test checks if you can create a record correctly. */
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
    /* This test checks if you can add a image to a record. */
    public void test_addImageToRecord() {
        // Make sure make a test for more than 10 photoes.
        // Calendar currentTime = Calendar.getInstance();
        // Location location = new Location();

        Record testRecord = new Record();
        //testRecord.addPhoto();

    }

    /* This test checks if the maximum image limit triggers an error. */
}
