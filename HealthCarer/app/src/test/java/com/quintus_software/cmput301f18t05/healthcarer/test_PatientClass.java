package com.quintus_software.cmput301f18t05.healthcarer;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class test_PatientClass {

    @Test
    public void test_createPatient() {
        Patient derp = new Patient("Derp", "DER", "reole@derp.com"
                ,33, "rr", "S");

        assertEquals(derp.getName(), "Derp");
        assertEquals(derp.getBody(), "S");
        assertEquals(derp.getEmail(), "reole@derp.com");
        assertEquals(derp.getPhoneNumber(), "33");
        assertEquals(derp.getRole(), "rr");
        assertEquals(derp.getBody(), "S");
    }

    @Test
    public void test_addPatientProblem() {
        Patient derp = new Patient("Derp", "DER", "reole@derp.com"
                ,33, "rr", "S");
        Date currentTime = new Date();

        Problem problemExample = new Problem("Oww", currentTime, "Finger hurts.", "Owwy", "Finger");
//        derp.addProblem();


    }


}


