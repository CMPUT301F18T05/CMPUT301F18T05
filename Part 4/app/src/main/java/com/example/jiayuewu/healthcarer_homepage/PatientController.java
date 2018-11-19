package com.example.jiayuewu.healthcarer_homepage;


public class PatientController {
    private Patient patient;

    PatientController(Patient patient) {
        this.patient = patient;
    }

    public Problem getProblem(Integer index) {
        return patient.getProblem(index);
    }

    public void addProblem(Problem problem) {
        patient.addProblem(problem);
    }

    public void deleteProblem(Integer index) {
        patient.deleteProblem(index);
    }

}
