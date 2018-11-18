package com.example.jiayuewu.healthcarer_homepage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login = findViewById(R.id.login_login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent patient_intent = new Intent(login.this, homepage_patient.class);
                startActivityForResult(patient_intent, 0);
                //Intent doctor_intent = new Intent(login.this, homepage_doctor.class);
                //startActivityForResult(doctor_intent, 0);
            }
        });
    }
}
