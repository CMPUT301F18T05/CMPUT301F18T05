package com.example.jiayuewu.healthcarer_homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class view_patient_problem extends AppCompatActivity {
    private EditText titleText;
    private EditText partText;
    private EditText dateText;
    private EditText dText;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_patient_problem);
        setTitle("View Patient Problem");

        Intent get_intent = getIntent();
        String problem_id = get_intent.getStringExtra("problem_id");
        String title = get_intent.getStringExtra("title");
        String part = get_intent.getStringExtra("part");
        String date = get_intent.getStringExtra("date");
        String description = get_intent.getStringExtra("description");

        titleText = findViewById(R.id.patient_problem_title);
        partText = findViewById(R.id.patient_body_part);
        dateText = findViewById(R.id.patient_date_started);
        dText = findViewById(R.id.patient_problem_description);

        titleText.setText(title);
        partText.setText(part);
        dateText.setText(date);
        dText.setText(description);

        FloatingActionButton recordmap = findViewById(R.id.records_map_button);
        recordmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Go to Records Map", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton record = findViewById(R.id.patient_records_button);
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewAndEdit = new Intent(view_patient_problem.this, view_patient_records.class);
                startActivity(viewAndEdit);
            }
        });

        FloatingActionButton addcomment = findViewById(R.id.add_comment_button2);
        addcomment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ac = new Intent(view_patient_problem.this, add_doctor_comment.class);
                startActivity(ac);
            }
        });

    }
}
