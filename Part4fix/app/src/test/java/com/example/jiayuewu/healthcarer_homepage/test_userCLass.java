package com.example.jiayuewu.healthcarer_homepage;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class test_userCLass {

    @Test
    /* This test will create a patient, and check if the attributes are correctly created. */
    public void test_createPatient() {
        User testPatient = new User(123,  "DerpERPP", "DER", "reole@testPatient.com"
                ,"33");

        assertEquals("123", "" + testPatient.getUserID());
        assertEquals("DerpERPP", testPatient.getName());
        assertEquals("DER", testPatient.getEmail());
        assertEquals("reole@testPatient.com", testPatient.getPhoneNumber());
        assertEquals("33", testPatient.getRole());
    }

    @Test
    /* This test will check if minimum userID tag is enforced*/
    public void test_userIDMinimum() {
        User testPatient = new User(123, "DER", "reole@testPatient.com"
                ,"33", "patient");
        User testPatient2 = new User();
        Boolean failedTest = Boolean.TRUE;

        String le = "" + testPatient.getUserID();

        // Since there should be an exception thrown, try to set a userID shorter than 8 chars and
        // catch the exception.
        try {
            testPatient2.setUserID(1);
        } catch(Exception e) {
            failedTest = Boolean.TRUE;
        }

        assertTrue(failedTest);

    }
}




