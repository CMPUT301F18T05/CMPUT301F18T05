/**
 * view_patient
 *This part will show a list of doctor's patients
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
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class view_patient extends AppCompatActivity {
    private ArrayList<Problem> problems = new ArrayList<Problem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_patient);
        setTitle("View Patient Problems");
        Intent get_intent = getIntent();
        String get_userid = get_intent.getStringExtra("userid");


        ListView patients = findViewById(R.id.patient_problems_listview);
        List<String> test_array_list = new ArrayList<String>();
        //test_array_list.add("foo");
        //test_array_list.add("bar");

        elasticSearch.getProblemsTask getProblemsTask
                = new elasticSearch.getProblemsTask();
        getProblemsTask.execute(Integer.parseInt(get_userid));

        try {
            problems = getProblemsTask.get();

        }	catch (Exception e) {
            Log.e("Error", "Failed to get the user out of the async object.");
        }

        for (int i = 0; i < problems.size(); i++) {
            test_array_list.add(problems.get(i).getTitle());
        }

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                view_patient.this,
                android.R.layout.simple_list_item_1,
                test_array_list );

        patients.setAdapter(arrayAdapter);
        patients.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
                Intent vp = new Intent(view_patient.this, view_patient_problem.class);
                vp.putExtra("problem_id",problems.get(position).getProblemID());
                vp.putExtra("title",problems.get(position).getTitle());
                vp.putExtra("part",problems.get(position).getBodyPart());
                vp.putExtra("date",problems.get(position).getCalenderDate());
                vp.putExtra("description",problems.get(position).getDescription());
                startActivity(vp);
            }
        });
    }
}
