/**
 * login
 * This part user can login by their userID then if the userID is correct user can go the homepage.
 *
 *
 * @author: CMPUT301F18T05
 * @since: 1.0
 *
 * Copyright 2018 HSC
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.jiayuewu.healthcarer_homepage;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class login extends AppCompatActivity {
    private EditText useridText;
    private User user = new User();
    private ArrayList<User> userArrayList = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
        Button login = findViewById(R.id.login_login_button);
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                /**
                 * Shows a simple alert message when the message is longer then the limit.
                 *
                 * @author: MysticMagic
                 */
                final AlertDialog alertDialog = new AlertDialog.Builder(login.this).create();
                alertDialog.setTitle("Alert");
                alertDialog.setMessage("Cannot login. Check connectivity, or create a profile.");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });


                useridText = (EditText) findViewById(R.id.login_userid_text);
                Integer userid = Integer.parseInt(useridText.getText().toString());
                elasticSearch.getUserTask getUserTask
                        = new elasticSearch.getUserTask();
                getUserTask.execute(userid);

                try {
                    userArrayList = getUserTask.get();

                }	catch (Exception e) {
                    Log.e("Error", "Failed to get the user out of the async object.");
                }

                try {
                    user = userArrayList.get(0);

                    Log.w("GOT USER", "" + user.getUserID());

                    DataHolder.setData(user);
                    if (user.getRole().equals("Patient")) {

                        try {
                            Intent patient_intent = new Intent(login.this, homepage_patient.class);
                            startActivity(patient_intent);
                        } catch (Exception e) {
                            Log.i ("Error in trying to open", "Patient homepage");
                        }
                    }
                    if (user.getRole().equals("Doctor")) {
                        try {
                            Intent doctor_intent = new Intent(login.this, homepage_doctor.class);
                            startActivity(doctor_intent);
                        } catch (Exception e) {
                            Log.i ("Error in trying to open", "Doctor homepage");
                        }
                    }
                } catch (Exception e) {
                    Log.i("User", "Not found");

                    alertDialog.show();
                }




            }
        });

        final Context context = this;

    }
}
