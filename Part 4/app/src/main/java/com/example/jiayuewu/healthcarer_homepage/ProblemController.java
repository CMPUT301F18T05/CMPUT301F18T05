package com.example.jiayuewu.healthcarer_homepage;


public class ProblemController {
    private Problem problem;

    ProblemController(Problem problem) {
        this.problem = problem;
    }

    public void addRecord(Record record) {
        problem.addRecord(record);
    }

    public Record getRecord(Integer index) {
        return problem.getRecord(index);
    }

    public void deleteRecord(Integer index) {
        problem.deleteRecord(index);
    }
}
