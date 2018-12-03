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
    Context context = add_record.this;
    private Record newRecord = new Record();
    private ArrayList<Record> recordArrayList = new ArrayList<Record>();
    private EditText titleText;
    private EditText dateText;
    private EditText dText;
    private User user;
    private Integer userID, problemID, recordID;
    private Problem problem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
        setTitle("Add Record");
        problem = DataHolder_Problem.getData();
        problemID = problem.getProblemID();
        userID = problem.getUserID();

//        problemID = DataHolder_Problem.getData().getProblemID();

        Button addphoto = findViewById(R.id.add_photos_button);
        addphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ap = new Intent(add_record.this, add_photos_in_record.class);
                startActivity(ap);
            }
        });

        Button addmap = findViewById(R.id.patient_location_button);
        addmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent ap = new Intent(add_record.this, add_photos_in_record.class);
//                startActivity(ap);
            }
        });

        FloatingActionButton saveButton = findViewById(R.id.add_record_save_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date_text, title, description;
                Integer userid;
                Calendar cal;

                Date date;
                cal = Calendar.getInstance();
                date = cal.getTime();
                SimpleDateFormat sdf;
                sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                date_text = "" + sdf.format(date);

                recordID = 0;
                Integer userID = problem.getUserID();
                problemID = problem.getProblemID();

                titleText = (EditText) findViewById(R.id.patient_record_title);
                dateText = (EditText) findViewById(R.id.patient_record_timestamp2);
                dText = (EditText) findViewById(R.id.patient_record_description);

                title = titleText.getText().toString();
                description = dText.getText().toString();
                dateText.setText(date_text);

                if (!connectivityChecker.getConnectivity(context)) {
                    recordID = findOfflineLastID();
                    Record newRecord = new Record(userID, problemID, recordID, title, date_text, description);

                    recordArrayList = DataHolderEverything.getRecordList();
                    recordArrayList.add(newRecord);
                    DataHolderEverything.setRecordList(recordArrayList);

                } else {
                    recordID = findLastID(userID, problemID, v);

                    Record newRecord = new Record(userID, problemID, recordID, title, date_text, description);

                    elasticSearch.addRecordTask task2
                            = new elasticSearch.addRecordTask();
                    task2.execute(newRecord);
                }
            }
        });
    }

    public Integer findLastID(Integer userID, Integer problemID, View v) {
        Integer unusedRecordID = 0;


        ArrayList<Record> recordList = new ArrayList<>();

        while (Boolean.TRUE) {
            elasticSearch.getRecordsTask task
                    = new elasticSearch.getRecordsTask();

            Log.i("addRecord", "Search ign for : " + userID + " " + unusedRecordID);

            task.execute(userID, problemID, unusedRecordID);
            try {
                recordList = task.get();
            } catch (Exception e) {
                Log.i("ADD_RECORD", "HAD AN EXCEPTION");
                break;
            }

            try {
                recordList = task.get();
            } catch (Exception e) {
            }

            if (recordList.size() == 0) {
                break;
            }
            unusedRecordID++;
        }

        Log.i("Add_RECORD", "GOT THIS NUMBER BACK : " + unusedRecordID + " " + recordList);
        return unusedRecordID;
    }

    public Integer findOfflineLastID() {
        ArrayList<Record> listOfRecords = DataHolderEverything.getRecordList();
        Integer maxNumber = 0;
        ArrayList<Integer> listOfID = new ArrayList<>();

        for (Record record : listOfRecords) {
            listOfID.add(record.getRecordID());
        }

        for (Integer ID : listOfID) {
            if (listOfID.contains(maxNumber)) {
                maxNumber++;
            } else {
                break;
            }
        }

        return maxNumber;
    }
}
