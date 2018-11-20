package com.example.jiayuewu.healthcarer_homepage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

import io.searchbox.core.Doc;

public class mainpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        final Button newprofile = findViewById(R.id.new_profile_button);
        Button login = findViewById(R.id.login_button);
        newprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newprofile_intent = new Intent(mainpage.this, newprofile.class);
                startActivityForResult(newprofile_intent, 0);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent login_intent = new Intent(mainpage.this, login.class);
//                startActivityForResult(login_intent, 0);

                Doctor_Comment dc = new Doctor_Comment(123,123,"ASD",
                        "ASD",Calendar.getInstance(), "ASD");

                elasticSearch.addDoctorCommentTask addTweetsTask
                        = new elasticSearch.addDoctorCommentTask();
                addTweetsTask.execute(dc);


            }
        });
    }
}
