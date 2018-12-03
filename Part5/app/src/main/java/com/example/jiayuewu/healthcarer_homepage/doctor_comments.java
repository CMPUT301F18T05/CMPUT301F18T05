/**
 * add_doctor_comment class
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

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import io.searchbox.core.Doc;

public class doctor_comments extends AppCompatActivity {

    private Doctor_Comment doctor_comment = new Doctor_Comment();
    private ArrayList<Doctor_Comment> doctorCommentArrayList = new ArrayList<Doctor_Comment>();
    private ArrayAdapter<Doctor_Comment> adapter;
    private User user;
    //open the activity_all_problem layout
    //start showing problem history screen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_comments);
        setTitle("View Doctor Comments");
    }

    /**
     *
     */
    // get user's id from the user data
    // get user's problem history
    // display the history to the search_result listview
    // set onclick in order to let user see the problem details
    // once clkicked, jump to detail's screen (view_patient_problem)
    @Override
    protected void onStart() {
        super.onStart();
        user = DataHolder.getData();
        Integer ID = user.getUserID();

        Integer problemID;
        problemID = Integer.parseInt(getIntent().getStringExtra("problemID"));


        elasticSearch.getDoctorCommentTask getProblemsTask = new elasticSearch.getDoctorCommentTask();
        getProblemsTask.execute(problemID, ID);

        try{
            doctorCommentArrayList = getProblemsTask.get();
        } catch (Exception e){
            Log.e("Error", "Failed to get the doctor_comment history out of the async object.");
        }

        Log.i("doctor_comments","" + doctorCommentArrayList);
        adapter = new ArrayAdapter<>(this, R.layout.list_item, doctorCommentArrayList);
        ListView history = findViewById(R.id.doctor_comments_listview);
        history.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        history.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
                Intent viewAndEdit = new Intent(doctor_comments.this, view_doctor_comment.class);
                Doctor_Comment dcObject;
                dcObject = doctorCommentArrayList.get(position);
                Doctor_Comment_Holder.setData(dcObject);
                startActivity(viewAndEdit);
            }
        });

    }

}
