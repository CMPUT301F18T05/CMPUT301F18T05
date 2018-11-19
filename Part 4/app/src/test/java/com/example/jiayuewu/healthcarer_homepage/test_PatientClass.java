package com.example.jiayuewu.healthcarer_homepage;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class test_PatientClass {

//    @Test
//    /* This test will create a patient, and check if the attributes are correctly created. */
//    public void test_createPatient() {
//        Patient testPatient = new Patient("DerpERPP", "DER", "reole@testPatient.com"
//                ,"33", "rr", "S");
//
//        assertEquals("DerpERPP", testPatient.getUserID());
//        assertEquals("S", testPatient.getName());
//        assertEquals("reole@testPatient.com", testPatient.getEmail());
//        assertEquals("33", testPatient.getPhoneNumber());
//        assertEquals("rr", testPatient.getRole());
//        assertEquals("S", testPatient.getBody());
//    }
//
//    @Test
//    /* This test will create a patient and problem, and add the problem to the patient. */
//    public void test_addPatientProblem() {
//        Patient testPatient = new Patient("DerpERPP", "DER", "reole@derp.com"
//                ,"33", "rr", "S");
//        Calendar currentTime = Calendar.getInstance();
//        Problem testProblem = new Problem("Oww", currentTime, "Finger hurts."
//                , "Owwy", "Finger");
//        testPatient.addProblem(testProblem);
//
//        assertEquals(currentTime, testPatient.getProblem(0).getCalenderDate());
//        assertEquals("Oww", testPatient.getProblem(0).getTitle());
//        assertEquals("Finger hurts.", testPatient.getProblem(0).getDescription());
//        assertEquals("Owwy", testPatient.getProblem(0).getType());
//        assertEquals("Finger", testPatient.getProblem(0).getBodyPart());
//    }
//
//    @Test
//    /* This problem will add multiple problems to a patient. */
//    public void test_addMultipleProblems() {
//        Patient testPatient = new Patient("DerpERPP", "DER", "reole@derp.com"
//                ,"33", "rr", "S");
//        Calendar currentTime = Calendar.getInstance();
//
//        Problem testProblem1 = new Problem("Oww", currentTime, "Finger hurts."
//                , "Owwy", "Finger");
//        Problem testProblem2 = new Problem("Worse", currentTime, "Feelings are great."
//                , "Good", "Ego");
//
//        testPatient.addProblem(testProblem1);
//        testPatient.addProblem(testProblem2);
//
//        assertTrue(testPatient.getProblem(0).equals(testProblem1));
//        assertTrue(testPatient.getProblem(1).equals(testProblem2));
//    }
//
//    @Test
//    /* This test will check if another method for checking problems in patient works. */
//    public void test_checkProblemsInList() {
//        Patient testPatient = new Patient("DerpERPP", "DER", "reole@derp.com"
//                ,"33", "rr", "S");
//        Calendar currentTime = Calendar.getInstance();
//
//        Problem testProblem1 = new Problem("Oww", currentTime, "Finger hurts."
//                , "Owwy", "Finger");
//        Problem testProblem2 = new Problem("Worse", currentTime, "Feelings are great."
//                , "Good", "Ego");
//
//        testPatient.addProblem(testProblem1);
//        testPatient.addProblem(testProblem2);
//
//        assertTrue(testPatient.getProblemList().contains(testProblem1));
//        assertTrue(testPatient.getProblemList().contains(testProblem2));
//    }
//
//    @Test
//    /* This test will check if deleting a problem from a patient works. */
//    public void test_deleteProblemsInList() {
//        Patient testPatient = new Patient("DerpERPP", "DER", "reole@derp.com"
//                ,"33", "rr", "S");
//        Calendar currentTime = Calendar.getInstance();
//
//        Problem testProblem1 = new Problem("Oww", currentTime, "Finger hurts."
//                , "Owwy", "Finger");
//        Problem testProblem2 = new Problem("Worse", currentTime, "Feelings are great."
//                , "Good", "Ego");
//
//        testPatient.addProblem(testProblem1);
//        testPatient.addProblem(testProblem2);
//        testPatient.deleteProblem(0);
//
//        assertFalse(testPatient.getProblemList().contains(testProblem1));
//        assertTrue(testPatient.getProblemList().contains(testProblem2));
//    }
//
//    @Test
//    /* This test will check if removing a patient from the doctor removes it*/
//    public void test_userIDMinimum() {
//        Patient testPatient = new Patient("DerpERPP", "DER", "reole@testPatient.com"
//                ,"33", "patient", "ARM");
//        Patient testPatient2 = new Patient();
//        Boolean failedTest = Boolean.FALSE;
//
//        assertTrue(testPatient.getUserID().length() >= 8);
//
//        // Since there should be an exception thrown, try to set a userID shorter than 8 chars and
//        // catch the exception.
//        try {
//            testPatient2.setUserID("D");
//        } catch(Exception e) {
//            failedTest = Boolean.TRUE;
//        }
//
//        assertTrue(failedTest);
//
//    }

}



