package com.quintus_software.cmput301f18t05.healthcarer;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class test_PatientClass {

    @Test
    public void test_createPatient() {
        Patient testPatient = new Patient("Derp", "DER", "reole@testPatient.com"
                ,33, "rr", "S");

        assertEquals("Derp", testPatient.getName());
        assertEquals("S", testPatient.getBody());
        assertEquals("reole@testPatient.com", testPatient.getEmail());
        assertEquals("33", testPatient.getPhoneNumber());
        assertEquals("rr", testPatient.getRole());
        assertEquals("S", testPatient.getBody());
    }

    @Test
    public void test_addPatientProblem() {
        Patient testPatient = new Patient("Derp", "DER", "reole@derp.com"
                ,33, "rr", "S");
        Calendar currentTime = Calendar.getInstance();
        Problem testProblem = new Problem("Oww", currentTime, "Finger hurts."
                , "Owwy", "Finger");
        testPatient.addProblem(testProblem);

        assertEquals(currentTime, testPatient.getProblem(0).getCalenderDate());
        assertEquals("Oww", testPatient.getProblem(0).getTitle());
        assertEquals("Finger hurts.", testPatient.getProblem(0).getDescription());
        assertEquals("Owwy", testPatient.getProblem(0).getType());
        assertEquals("Finger", testPatient.getProblem(0).getBodyPart());
    }

    @Test
    public void test_addMultipleProblems() {
        Patient testPatient = new Patient("Derp", "DER", "reole@derp.com"
                ,33, "rr", "S");
        Calendar currentTime = Calendar.getInstance();

        Problem testProblem1 = new Problem("Oww", currentTime, "Finger hurts."
                , "Owwy", "Finger");
        Problem testProblem2 = new Problem("Worse", currentTime, "Feelings are great."
                , "Good", "Ego");

        testPatient.addProblem(testProblem1);
        testPatient.addProblem(testProblem2);

        assertTrue(testPatient.getProblem(0).equals(testProblem1));
        assertTrue(testPatient.getProblem(1).equals(testProblem2));
    }

    @Test
    public void test_checkProblemsInList() {
        Patient testPatient = new Patient("Derp", "DER", "reole@derp.com"
                ,33, "rr", "S");
        Calendar currentTime = Calendar.getInstance();

        Problem testProblem1 = new Problem("Oww", currentTime, "Finger hurts."
                , "Owwy", "Finger");
        Problem testProblem2 = new Problem("Worse", currentTime, "Feelings are great."
                , "Good", "Ego");

        testPatient.addProblem(testProblem1);
        testPatient.addProblem(testProblem2);

        assertTrue(testPatient.getProblemList().contains(testProblem1));
        assertTrue(testPatient.getProblemList().contains(testProblem2));
    }

    @Test
    public void test_deleteProblemsInList() {
        Patient testPatient = new Patient("Derp", "DER", "reole@derp.com"
                ,33, "rr", "S");
        Calendar currentTime = Calendar.getInstance();

        Problem testProblem1 = new Problem("Oww", currentTime, "Finger hurts."
                , "Owwy", "Finger");
        Problem testProblem2 = new Problem("Worse", currentTime, "Feelings are great."
                , "Good", "Ego");

        testPatient.addProblem(testProblem1);
        testPatient.addProblem(testProblem2);
        testPatient.deleteProblem(0);

        assertFalse(testPatient.getProblemList().contains(testProblem1));
        assertTrue(testPatient.getProblemList().contains(testProblem2));
    }

}



