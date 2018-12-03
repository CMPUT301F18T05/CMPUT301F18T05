/**
 * view_record
 *This part patients can add record which can add Title and description
 * User can add photos and locations (Does not be implemented)
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

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class view_record extends AppCompatActivity {
    private EditText titleText;
    private EditText dateText;
    private EditText dText;
    private Record record;
    private ArrayList<Record> problemArrayList = new ArrayList<Record>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_record);
        setTitle("View Record");

        Record record = DataHolder_Record.getData();

        titleText = (EditText) findViewById(R.id.patient_record_title);
        dateText = (EditText) findViewById(R.id.patient_record_timestamp);
        dText = (EditText) findViewById(R.id.patient_record_description);

        elasticSearch.getSpecialProblem task2
                = new elasticSearch.getSpecialProblem();
        task2.execute(problemID, userid);

        try {
            problemArrayList = task2.get();
        }	catch (Exception e) {
            Log.e("Error", "Failed to get the problem out of the async object.");
        }

        problem = problemArrayList.get(0);

        titleText.setText(problem.getTitle());
        dateText.setText(problem.getCalenderDate());
        dText.setText(problem.getDescription());


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

                elasticSearch.deleteProblemTask task1
                        = new elasticSearch.deleteProblemTask();
                task1.execute(userid,problemID);

                Problem problem = new Problem(userid, problemID, title, date_text, description);
                elasticSearch.addProblemTask task2
                        = new elasticSearch.addProblemTask();
                task2.execute(problem);

            }
        });

        deleteProblem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elasticSearch.deleteProblemTask task1
                        = new elasticSearch.deleteProblemTask();
                task1.execute(userid,problemID);
            }
        });

        viewrecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vr= new Intent(view_problem.this, view_records.class);
                vr.putExtra("problemID",String.valueOf(problemID));
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
