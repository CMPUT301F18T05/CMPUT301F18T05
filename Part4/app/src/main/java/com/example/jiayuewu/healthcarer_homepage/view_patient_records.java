/**
 * view_patient_records
 *This part will show a list of patient records
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
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class view_patient_records extends AppCompatActivity {
    private ArrayList<Record> records = new ArrayList<Record>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_patient_records);
        setTitle("View Patient Records");

        Intent get_intent = getIntent();
        String problem_id = get_intent.getStringExtra("problem_id");
        String problem_title = get_intent.getStringExtra("problem_title");

        EditText title = findViewById(R.id.patient_records_of_text);
        title.setText(problem_title);

        elasticSearch.getRecordsTask getRecordsTask
                = new elasticSearch.getRecordsTask();
        getRecordsTask.execute(Integer.parseInt(problem_id));

        try {
            records = getRecordsTask.get();

        }	catch (Exception e) {
            Log.e("Error", "Failed to get the user out of the async object.");
        }

        ListView patients = findViewById(R.id.patient_records_listview);
        List<String> test_array_list = new ArrayList<String>();
        //test_array_list.add("foo");
        //test_array_list.add("bar");

        for (int i = 0; i < records.size(); i++) {
            test_array_list.add(records.get(i).getTitle());
        }

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                view_patient_records.this,
                android.R.layout.simple_list_item_1,
                test_array_list );

        patients.setAdapter(arrayAdapter);
        patients.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
                Intent vp = new Intent(view_patient_records.this, view_patient_record.class);
                vp.putExtra("record_id",records.get(position).getRecordID());
                vp.putExtra("record_title",records.get(position).getTitle());
                vp.putExtra("record_comment",records.get(position).getComment());
                vp.putExtra("record_time",records.get(position).getDate());
                startActivity(vp);
            }
        });
    }
}
