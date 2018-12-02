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
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class add_record extends AppCompatActivity {

    Context context;
    private Record newRecord = new Record();
    private String description = "";
    private String title = "";
    private ArrayList<Image> imageList = new ArrayList<Image>();


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
                context = add_record.this;

                // Todo: Need to save the record to elastic search

                // Do a bunch of checks.




            }
        });

    }
}
