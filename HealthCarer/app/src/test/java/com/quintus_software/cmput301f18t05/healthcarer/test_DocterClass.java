package com.quintus_software.cmput301f18t05.healthcarer;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class test_DocterClass {

    @Test
    /*This test case will create a doctor, and check that the fields are created correctly. */
    public void test_createDoctor() {
        Doctor testDoctor = new Doctor("Derp", "DER", "reole@testPatient.com"
                ,"33", "doc");

        assertEquals("Derp", testDoctor.getUserID());
        assertEquals("DER", testDoctor.getName());
        assertEquals("reole@testPatient.com", testDoctor.getEmail());
        assertEquals("33", testDoctor.getPhoneNumber());
        assertEquals("doc", testDoctor.getRole());
    }

    @Test
    /*This test will create a patient and doctor, and add the patient to the doctor. */
    public void test_add_get_Patient() {
        Doctor testDoctor = new Doctor("Derp", "DER", "reole@testPatient.com"
                ,"33", "doc");
        Patient testPatient = new Patient("Derp", "DER", "reole@testPatient.com"
                ,"33", "rr", "S");

        testDoctor.addPatient(testPatient);
        assertEquals(testPatient, testDoctor.getPatient(0));
    }

    @Test
    /* This test will check if removing a patient from the doctor removes it*/
    public void test_removePatient() {
        Doctor testDoctor = new Doctor("Derp", "DER", "reole@testPatient.com"
                ,"33", "doc");
        Patient testPatient1 = new Patient("Derp", "DER", "reole@testPatient.com"
                ,"33", "rr", "S");
        Patient testPatient2 = new Patient("Depo", "DEMO", "renoboi@testPatient.com"
                ,"355", "rr", "S");

        testDoctor.addPatient(testPatient1);
        testDoctor.addPatient(testPatient2);
        testDoctor.removePatient(0);
        assertEquals(testPatient2, testDoctor.getPatient(0));
    }

}
