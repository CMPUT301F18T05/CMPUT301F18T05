package com.quintus_software.cmput301f18t05.healthcarer;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class test_DoctorComment {

    @Test
    public void test_createComment() {
        Doctor_Comment testDoctorComment = new Doctor_Comment();
        Calendar currentTime = Calendar.getInstance();

        testDoctorComment.setName("FinalTest");
        testDoctorComment.setComment("Please");
        testDoctorComment.setTitle("GERGEEG");
        testDoctorComment.setDate(currentTime);

        assertEquals("FinalTest", testDoctorComment.getName());
        assertEquals("Please", testDoctorComment.getComment());
        assertEquals("GERGEEG", testDoctorComment.getTitle());
        assertEquals(currentTime, testDoctorComment.getDate());
    }

    @Test
    public void test_createCommentConstuctor() {
        Calendar currentTime = Calendar.getInstance();
        Doctor_Comment testDoctorComment = new Doctor_Comment("GERGEEG", "FinalTest"
                , currentTime, "Plase");

        assertEquals("FinalTest", testDoctorComment.getName());
        assertEquals("Please", testDoctorComment.getComment());
        assertEquals("GERGEEG", testDoctorComment.getTitle());
        assertEquals(currentTime, testDoctorComment.getDate());
    }

}
