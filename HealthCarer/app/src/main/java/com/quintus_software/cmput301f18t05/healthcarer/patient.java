package com.quintus_software.cmput301f18t05.healthcarer;

import java.util.Date;

public class patient {

    private String date;
    private String message;
    private String problem;
    patient(String problem, Date Date1, String message) {
        this.problem = problem;
        this.date = Date1.toString();
        this.message = message;
    }
}
