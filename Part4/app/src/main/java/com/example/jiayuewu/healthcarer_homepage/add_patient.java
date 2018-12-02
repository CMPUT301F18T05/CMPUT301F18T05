/**
 * add_patient class used to add patients to doctor.
 *This part Doctor user can add patients.
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

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class add_patient extends AppCompatActivity {
    private ArrayList<User> userArrayList = new ArrayList<User>();
    private User user = new User();
    private EditText userid = findViewById(R.id.login_userid_text2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);
        setTitle("Add Patient");

        FloatingActionButton add = findViewById(R.id.save_patient_button);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elasticSearch.getUserTask getUserTask
                        = new elasticSearch.getUserTask();
                getUserTask.execute(Integer.parseInt(userid.getText().toString()));

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
                            //test_array_list.add(user.getName());
                            //add placeholder
                        } catch (Exception e) {
                            Log.i("Error in trying to open", "Patient homepage");
                        }
                    }
                    if (user.getRole().equals("Doctor")) {
                        try {
                            Snackbar.make(v, "user is doctor, unable to add", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        } catch (Exception e) {
                            Log.i("Error in trying to open", "Doctor homepage");
                        }
                    }
                } catch (Exception e) {
                    Log.e("Error", "Failed to get the user out of the async object.");
                }
            }
        });


    }
}
