package com.example.jiayuewu.healthcarer_homepage;


public class DoctorController extends Doctor {
    Doctor childDoctor = new Doctor();

    DoctorController(Doctor doctor) {
        this.childDoctor = doctor;
    }

    public void addPatient(Patient patient) {
        this.childDoctor.addPatient(patient);
    }

    public Patient getPatient(Integer index) {
        return this.getPatient(index);
    }

    public void removePatient(Integer index) {
        this.childDoctor.removePatient(index);
    }

}
