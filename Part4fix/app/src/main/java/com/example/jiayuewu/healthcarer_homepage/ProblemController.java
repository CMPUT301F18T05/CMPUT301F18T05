package com.example.jiayuewu.healthcarer_homepage;


import java.util.ArrayList;

public class ProblemController {
    private Problem problem;
    private ArrayList<Doctor_Comment> doctorComentList = new ArrayList<Doctor_Comment>();
    private ArrayList<Record> recordList  = new ArrayList<Record>();

    ProblemController(Problem problem) {
        this.problem = problem;
    }

    public void addDoctorComment(Doctor_Comment doctor_comment){
        this.doctorComentList.add(doctor_comment);
    }

    public Doctor_Comment getDoctorComment(Integer index){
        return this.doctorComentList.get(index);
    }

    public ArrayList<Record> getRecordList() {
        return this.recordList;
    }

    public void addRecord(Record record) {
        this.recordList.add(record);
    }

    public Record getRecord(Integer index) {
        return this.recordList.get(index);
    }

    public void deleteRecord(Integer index) {
        this.recordList.remove(index);
    }
}
