package com.quintus_software.cmput301f18t05.healthcarer;

import java.util.ArrayList;

public class Docter extends User {

    private ArrayList<Patient> patientList = new ArrayList<Patient>();

    Docter() {

    }

    public void addPatient(Patient patient) {
        this.patientList.add(patient);
    }

    public Patient getPatient(Integer index) {
        return this.patientList.get(index);
    }
}

