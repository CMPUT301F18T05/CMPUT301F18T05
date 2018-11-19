package com.example.jiayuewu.healthcarer_homepage;

import android.graphics.Bitmap;
import android.location.Location;
import android.media.Image;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class test_RecordClass {

//    @Test
//    /* This test checks if you can create a record correctly. */
//    public void test_setRecord() {
//        Calendar currentTime = Calendar.getInstance();
//        Record testRecord = new Record();
//        Location location = new Location("dummyprovider");
//
//        testRecord.setComment("Finger");
//        testRecord.setDate(currentTime);
//        testRecord.setTitle("Finger hurts.");
//        testRecord.setType("Oww");
//        testRecord.setLocation(location);
//
//        // It should all pass. (True, True)
//        assertEquals(currentTime, testRecord.getDate());
//        assertEquals("Finger", testRecord.getComment());
//        assertEquals("Finger hurts.", testRecord.getTitle());
//        assertEquals("Oww", testRecord.getType());
//        assertEquals(location, testRecord.getLocation());
//    }
//
//    @Test
//    /* This test checks if you can add a image to a record. */
//    public void test_addImageToRecord() {
//        // Make sure make a test for more than 10 photoes.
//        // Calendar currentTime = Calendar.getInstance();
//        // Location location = new Location();
//
//        Record testRecord = new Record();
//        //testRecord.addPhoto();
//    }
//
//    @Test
//    /* Test that adding too many images throws an exception */
//    /* This test checks if the maximum image limit triggers an error. */
//    public void test_maxImageAmount() {
//        Bitmap.Config conf = Bitmap.Config.ARGB_8888; // see other conf types
//        Bitmap bmp = Bitmap.createBitmap(1, 1, conf); // this creates a MUTABLE bitmap
//        ArrayList<Bitmap> listOfImages = new ArrayList<Bitmap>();
//        String fail = "0";
//
//        for (Integer i = 0; i < 10; i++) {
//            listOfImages.add(bmp);
//        }
//
//        // Junit3 doesn't allow to assert a exception, so this is a work around
//        try {
//            listOfImages.add(bmp);
//        } catch (Exception e) {
//            fail = "0";
//        }
//
//        assertEquals("0", fail);
//    }
//
//    @Test
//    public void test_commentLengthMaximum() {
//        Record testRecord = new Record();
//        Boolean failedTest = Boolean.FALSE;
//        String failString = new String();
//
//        for (Integer i = 0; i < 301; i++) {
//            failString += "D";
//        }
//
//        try {
//            testRecord.setComment(failString);
//        } catch (Exception e) {
//            failedTest = Boolean.TRUE;
//        }
//
//        Calendar currentTime = Calendar.getInstance();
//        Location location = new Location("dummyprovider");
//        Record testRecord2 = new Record("Finger", currentTime, location, "oww", "location");
//
//        // Test to make sure that the
//        assertTrue(testRecord2.getTitle().length() <= 300);
//
//    }
//
//    @Test
//    /* Testing is to make sure that a title less than or equal to 30 characters is permissible*/
//    public void test_titleLengthMaximum() {
//        Record testRecord = new Record();
//        Boolean failedTest = Boolean.FALSE;
//        String failString = new String();
//
//        for (Integer i = 0; i < 30; i++) {
//            failString += "E";
//        }
//
//        // Idea here is to test setting a below the minimum required characters. (This should throw
//        // an exception. The try statement is because Junit3 doesn't assertNotException (Junit4 can))
//        try {
//            testRecord.setTitle(failString);
//        } catch(Exception e) {
//            failedTest = Boolean.TRUE;
//        }
//
//        assertTrue(failedTest);
//
//        Calendar currentTime = Calendar.getInstance();
//        Location location = new Location("dummyprovider");
//        Record testRecord2 = new Record("Finger", currentTime, location, "oww", "location");
//
//        // Test to make sure that the length is less than 30 characters long.
//        assertTrue(testRecord2.getTitle().length() <= 30);
//
//    }


}