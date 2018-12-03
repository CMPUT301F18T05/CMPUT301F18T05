/**
 * view_problem
 *This part user can view the problem they add and edit or delete it.
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
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class view_problem extends AppCompatActivity {
    private EditText titleText;
    private EditText dateText;
    private EditText dText;
    private TextView countText;
    private User user;
    private Integer problemID;
    private Problem problem;
    private Integer userid;
    private ArrayList<Problem> problemArrayList = new ArrayList<Problem>();
    private Context context = view_problem.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_problem);
        setTitle("View Problem");
        user = DataHolder.getData();
        userid = user.getUserID();

        titleText = (EditText) findViewById(R.id.patient_problem_title);
        dateText = (EditText) findViewById(R.id.patient_problem_date);
        dText = (EditText) findViewById(R.id.patient_problem_description);

        problem = DataHolder_Problem.getData();
        problemID = problem.getProblemID();

        titleText.setText(problem.getTitle());
        dateText.setText(problem.getCalenderDate());
        dText.setText(problem.getDescription());

        countText = (TextView) findViewById(R.id.count);

        elasticSearch.getAllRecordsTask Task
                = new elasticSearch.getAllRecordsTask();
        Task.execute(userid, problemID);
        ArrayList<Record> arrayList = new ArrayList<Record>();
        try {
            arrayList = Task.get();
        }	catch (Exception e) {
            Log.e("Error", "Failed to get the record out of the async object.");
        }
        Integer length = arrayList.size();

        if (length == -1) {
            countText.setText("0");
        } else {
            countText.setText(String.valueOf(length));
        }

        Button rButton = (Button) findViewById(R.id.Reminder_button);
        rButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);

                //passing the emotion count to new activity
                Intent intent = new Intent(view_problem.this, RemindActivity.class);
                view_problem.this.startActivity(intent);
            }
        });

        FloatingActionButton viewrecords = findViewById(R.id.patient_records_button);
        FloatingActionButton doctorcomments = findViewById(R.id.view_doctor_comment);
        FloatingActionButton saveProblem = findViewById(R.id.problem_save_button);
        FloatingActionButton deleteProblem = findViewById(R.id.problem_delete_button);

        saveProblem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date_text, title, description;

                date_text = dateText.getText().toString();
                title = titleText.getText().toString();
                description = dText.getText().toString();

                Problem oldProblem = problem;
                Problem newProblem = new Problem(userid, problemID, title, date_text, description);

                if (!connectivityChecker.getConnectivity(context)) {
                    problemArrayList = DataHolderEverything.getProblemList();
                    problemArrayList.remove(oldProblem);
                    problemArrayList.add(newProblem);
                    DataHolderEverything.setProblemList(problemArrayList);
                } else {
                    elasticSearch.deleteProblemTask task1
                            = new elasticSearch.deleteProblemTask();
                    task1.execute(userid, problemID);

                    elasticSearch.addProblemTask task2
                            = new elasticSearch.addProblemTask();
                    task2.execute(newProblem);
                }
                Snackbar.make(v, "Problem has been saved.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        deleteProblem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!connectivityChecker.getConnectivity(context)) {
                    problemArrayList = DataHolderEverything.getProblemList();
                    problemArrayList.remove(problem);
                    DataHolderEverything.setProblemList(problemArrayList);
                } else {
                    elasticSearch.deleteProblemTask task1
                            = new elasticSearch.deleteProblemTask();
                    task1.execute(userid,problemID);
                }
                Snackbar.make(v, "Problem has been deleted.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        viewrecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vr= new Intent(view_problem.this, view_records.class);
                vr.putExtra("problemID",String.valueOf(problemID));
                vr.putExtra("problemTitle",problem.getTitle());
//                DataHolder_Problem.setData(problem);
                startActivity(vr);
            }
        });

        doctorcomments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dc= new Intent(view_problem.this, doctor_comments.class);
                dc.putExtra("problemID",String.valueOf(problemID));
                startActivity(dc);
            }
        });
    }
}
