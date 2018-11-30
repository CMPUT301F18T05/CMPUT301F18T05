package com.example.jiayuewu.healthcarer_homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class view_patient_problem extends AppCompatActivity {
    private EditText titleText;
    private EditText dateText;
    private EditText dText;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_problem);

        FloatingActionButton saveProblem = findViewById(R.id.problem_save_button);
        saveProblem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        FloatingActionButton record = findViewById(R.id.patient_records_button);
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewAndEdit = new Intent(view_patient_problem.this, view_records.class);
                startActivity(viewAndEdit);
            }
        });

    }
}
