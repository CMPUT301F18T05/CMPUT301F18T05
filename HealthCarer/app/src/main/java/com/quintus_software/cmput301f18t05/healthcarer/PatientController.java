package com.quintus_software.cmput301f18t05.healthcarer;

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
