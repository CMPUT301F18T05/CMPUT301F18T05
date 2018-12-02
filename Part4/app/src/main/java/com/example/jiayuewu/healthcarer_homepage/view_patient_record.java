/**
 * Patient_record
 *This part will show patients' record and can go a new page to add a new record.
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
import android.widget.EditText;
import android.widget.TextView;

public class view_patient_record extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_patient_record);
        setTitle("View Patient Record");
        Intent get_intent = getIntent();
        String record_id = get_intent.getStringExtra("record_id");
        String record_title = get_intent.getStringExtra("record_title");
        String record_comment = get_intent.getStringExtra("record_comment");
        String record_time = get_intent.getStringExtra("record_time");
        EditText title = findViewById(R.id.patient_record_title);
        EditText comment = findViewById(R.id.patient_record_description);
        TextView time = findViewById(R.id.patient_record_timestamp);
        title.setText(record_title);
        comment.setText(record_comment);
        time.setText(record_time);
    }
}
