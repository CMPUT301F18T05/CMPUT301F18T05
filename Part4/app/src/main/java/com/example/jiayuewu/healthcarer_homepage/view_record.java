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
import android.location.Location;
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
    private ArrayList<Record> recordArrayList = new ArrayList<Record>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_record);
        setTitle("View Record");

        record = DataHolder_Record.getData();

        titleText = (EditText) findViewById(R.id.patient_record_title);
        dateText = (EditText) findViewById(R.id.patient_record_timestamp);
        dText = (EditText) findViewById(R.id.patient_record_description);


        titleText.setText(record.getTitle());
        dateText.setText(record.getDate());
        dText.setText(record.getComment());


        Button addphoto = findViewById(R.id.patient_photos_button);
        addphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ap = new Intent(view_record.this, add_photos_in_record.class);
                startActivity(ap);
            }
        });

        Button addmap = findViewById(R.id.patient_location_button);
        addmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent ap = new Intent(view_record.this, add_photos_in_record.class);
//                startActivity(ap);
            }
        });

        FloatingActionButton saveProblem = findViewById(R.id.record_save_button);
        FloatingActionButton deleteProblem = findViewById(R.id.delete_record_button);

        saveProblem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date_text, title, description;
//                Location location;

                date_text = dateText.getText().toString();
                title = titleText.getText().toString();
                description = dText.getText().toString();

                elasticSearch.deleteRecordTask task1
                        = new elasticSearch.deleteRecordTask();
                task1.execute(record.getUserID(), record.getProblemID(), record.getRecordID());

                Record rec = new Record(record.getUserID(), record.getProblemID(), record.getRecordID(), title, date_text, description);
                // todo check if user picked location , update it otherwise keep it empty
//                rec.setLocation(location);
                elasticSearch.addRecordTask task2
                        = new elasticSearch.addRecordTask();
                task2.execute(rec);

            }
        });

        deleteProblem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elasticSearch.deleteRecordTask task1
                        = new elasticSearch.deleteRecordTask();
                task1.execute(record.getUserID(), record.getProblemID(), record.getRecordID());
            }
        });
    }
}
