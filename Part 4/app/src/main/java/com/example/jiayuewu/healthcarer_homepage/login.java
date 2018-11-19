package com.example.jiayuewu.healthcarer_homepage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class login extends AppCompatActivity {
    private EditText useridText;
    private User user = new User();
    private ArrayList<User> userArrayList = new ArrayList<User>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login = findViewById(R.id.login_login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("In loging", "s");

                useridText = (EditText) findViewById(R.id.login_userid_text);
                Integer userid = 0 + Integer.parseInt(useridText.getText().toString());
                elasticSearch.getUserTask getUserTask
                        = new elasticSearch.getUserTask();
                getUserTask.execute(userid);

                Log.w("AFETER", "ERER");


                try {
                    userArrayList = getUserTask.get();

                }	catch (Exception e) {
                    Log.e("Error", "Failed to get the tweets out of the async object.");
                }

                Log.w("AFTER TRY", "ASDASD");

                for (User u: userArrayList) {
                    if (u.getUserID() == userid) {
                        user = u;
                    }
                }

//                Log.w("ASDASD", "" + userArrayList.get(0));


                if (user.getUserID() == null) {
                    Log.w("DER", "ASDA");
                    if (user.getRole() == "Patient") {
                        Intent patient_intent = new Intent(login.this, homepage_patient.class);
                        startActivityForResult(patient_intent, 0);
                    } else {
                        Intent doctor_intent = new Intent(login.this, homepage_doctor.class);
                        startActivityForResult(doctor_intent, 0);
                    }
                } else {
                    Log.w("NOT LODDED IN", "DERP");
                }




            }
        });
    }
}
