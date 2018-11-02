package com.quintus_software.cmput301f18t05.healthcarer;

import java.util.ArrayList;

public class Patient extends User{

    private String body;
    private ArrayList<Problem> problemList  = new ArrayList<Problem>();

    Patient(String userID, String name, String email, String phoneNumber, String role,
            String body) {

    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Problem getProblem(Integer index) {
        return this.problemList.get(index);
    }

    public void addProblem(Problem problem) {
        this.problemList.add(problem);
    }

    public void deleteProblem(Integer index) {
        this.problemList.remove(index);
    }

    public ArrayList<Problem> getProblemList() {
        return this.problemList;
    }

}

