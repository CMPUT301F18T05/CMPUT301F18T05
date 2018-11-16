package com.example.jiayuewu.healthcarer_homepage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class login extends AppCompatActivity {
    TextView roles;
    EditText euserid;
    Spinner types;
    Button log;
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        roles=findViewById(R.id.textViewRole) ;
        euserid =findViewById(R.id.edituser);
        types=findViewById(R.id.spinner);
        log=findViewById(R.id.login2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.memberTypes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        types.setAdapter(adapter);
        log.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick( View view ) {
                Intent log = new Intent(login.this, homepage_patient.class);
                login.this.startActivity(log);
            }
        });


    }
}
