package com.quintus_software.cmput301f18t05.healthcarer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test_PatientClass {

    @Test
    public void test_createPatient() {
        Patient derp = new Patient("Derp", "DER", "reole@derp.com"
                ,33, "rr", "S");
        assertEquals(derp.getName(), "Derp");
//        assertEquals(4, 2 + 2);
    }

}


