/**
 * view_records
 *This part will show a list of all of patients' problems and can delete it
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
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class view_records extends AppCompatActivity {
    private Record record = new Record();
    private ArrayList<Record> recordArrayList = new ArrayList<Record>();
    private ArrayAdapter<Record> adapter;
    private EditText titleText;
    private User user;
    private Integer problemID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_records);
        setTitle("View Records");
        titleText = findViewById(R.id.patient_records_of_text);
        String title = getIntent().getStringExtra("problemTitle");
        titleText.setText(title);

        ListView patients = findViewById(R.id.view_records_listview);

        FloatingActionButton addrecord = findViewById(R.id.add_record_button);
        addrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ar = new Intent(view_records.this, add_record.class);
                ar.putExtra("problemID", String.valueOf(problemID));
                startActivity(ar);
            }
        });
    }

    protected void onStart() {
        super.onStart();
        user = DataHolder.getData();
        problemID = Integer.parseInt(getIntent().getStringExtra("problemID"));

        elasticSearch.getAllRecordsTask task2
                = new elasticSearch.getAllRecordsTask();
        task2.execute(user.getUserID(), problemID);

        try{
            recordArrayList = task2.get();
        } catch (Exception e){
            Log.e("View_records", "Failed to get the records history out of the async object.");
        }

        Log.i("view_records","" + recordArrayList);
        adapter = new ArrayAdapter<>(this, R.layout.list_item, recordArrayList);
        ListView history = findViewById(R.id.view_records_listview);
        history.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        history.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
                Intent viewAndEdit = new Intent(view_records.this, view_record.class);
                Record record;
                record = recordArrayList.get(position);
                DataHolder_Record.setData(record);
                startActivity(viewAndEdit);

            }
        });

    }
}
