/**
 * add_record to problem
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

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class add_record extends AppCompatActivity {
    Context context;
    private Record newRecord = new Record();
    private ArrayList<Record> imageList = new ArrayList<Image>();


    private EditText titleText;
    private EditText dateText;
    private EditText dText;
    private User user;
    private Integer problemID;
    private ArrayList<Problem> problemArrayList = new ArrayList<Problem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
        setTitle("Add Record");

        Button addphoto = findViewById(R.id.add_photos_button);
        addphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ap = new Intent(add_record.this, add_photos_in_record.class);
                startActivity(ap);
            }
        });

        FloatingActionButton saveButton = findViewById(R.id.add_record_save_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String part, date_text, title, description;
                Integer userid;
                Calendar cal;

                Date date;
                cal = Calendar.getInstance();
                date = cal.getTime();
                SimpleDateFormat sdf;
                sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                date_text = "" + sdf.format(date);

                problemID = 1;



                //part = getIntent().getStringExtra("part");
                user = DataHolder.getData();
                userid = user.getUserID();
                titleText = (EditText) findViewById(R.id.add_problem_title);
                dateText = (EditText) findViewById(R.id.add_problem_date);
                dText = (EditText) findViewById(R.id.add_problem_description);

                title = titleText.getText().toString();
                description = dText.getText().toString();
                dateText.setText(date_text);

                elasticSearch.getProblemsTask problemTask
                        = new elasticSearch.getProblemsTask();
                problemTask.execute(userid);

                try {
                    problemArrayList = problemTask.get();
                    problemID = findLastID(userid, v);

                }	catch (Exception e) {
                    Log.e("Error", "Failed to get the problem out of the async object.");
                }
                Integer length = problemArrayList.size() - 1;

                if (length == -1) {
                    problemID = 0;
                } else {
                    problemID = findLastID(userid, v);
                }


                Problem problem = new Problem(userid, problemID, title, date_text, description);
                elasticSearch.addProblemTask task2
                        = new elasticSearch.addProblemTask();
                task2.execute(problem);

            }
        });
    }

    public Integer findLastID(Integer userID, View v) {
        Integer unusedProblemID = 1;

        ArrayList<Problem> problemList = new ArrayList<>();

        while (Boolean.TRUE) {
            elasticSearch.getSpecialProblem task
                    = new elasticSearch.getSpecialProblem();

            Log.i("addProblem", "Search ign for : " + userID + " " + unusedProblemID);

            task.execute(new Integer[]{unusedProblemID, userID});
            try {

                problemList = task.get();

            } catch (Exception e) {
                Log.i("addProblem", "Error : " + e);
                Snackbar.make(v, "FUCKED UP", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            }

            try {
                problemList = task.get();
            } catch (Exception e) {
            }

            if (problemList.size() == 0) {
                break;
            }
            unusedProblemID++;
        }

        return unusedProblemID;
    }
}
