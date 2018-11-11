package com.quintus_software.cmput301f18t05.healthcarer;

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
