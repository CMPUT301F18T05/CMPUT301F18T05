package com.example.jiayuewu.healthcarer_homepage;


public class RecordController {
    private Record record;

    RecordController(Record record) {
        this.record = record;
    }


    public void addDoctorComment(Doctor_Comment doctor_comment){
        record.addDoctorComment(doctor_comment);
    }

    public Doctor_Comment getDoctorComment(Integer index){
        return record.getDoctorComment(index);
    }

}
