package com.example.jiayuewu.healthcarer_homepage;


import java.util.ArrayList;

public class Doctor extends User {

    private ArrayList<Patient> patientList = new ArrayList<Patient>();

    Doctor() {

    }

    Doctor(String userID, String name, String email, String phoneNumber, String role) {

    }

    public void addPatient(Patient patient) {
        this.patientList.add(patient);
    }

    public Patient getPatient(Integer index) {
        return this.patientList.get(index);
    }

    public void removePatient(Integer index) {
        this.patientList.remove(index);
    }
}

