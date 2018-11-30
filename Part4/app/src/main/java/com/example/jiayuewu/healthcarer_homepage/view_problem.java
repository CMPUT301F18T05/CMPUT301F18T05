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

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class view_problem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_problem);
        FloatingActionButton viewrecords = findViewById(R.id.patient_records_button);
        FloatingActionButton doctorcomments = findViewById(R.id.view_doctor_comment);
        FloatingActionButton saveproblem = findViewById(R.id.problem_save_button);
        FloatingActionButton deleteproblem = findViewById(R.id.problem_delete_button);

        viewrecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vr= new Intent(view_problem.this, view_records.class);
                startActivity(vr);
            }
        });

        doctorcomments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dc= new Intent(view_problem.this, doctor_comments.class);
                startActivity(dc);
            }
        });
    }
}
