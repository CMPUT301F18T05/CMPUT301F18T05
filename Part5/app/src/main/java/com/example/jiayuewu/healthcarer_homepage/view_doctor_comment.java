/**
 * view_doctor_comment class
 *This part will show doctor's comments
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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class view_doctor_comment extends AppCompatActivity {
    private EditText titleText;
    private EditText nameText;
    private EditText commentText;
    private Doctor_Comment doctor_comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_doctor_comment);
        setTitle("View Doctor Comment");

        titleText = (EditText) findViewById(R.id.doctor_comment_title);
        nameText = (EditText) findViewById(R.id.doctor_comment_name);
        commentText = (EditText) findViewById(R.id.doctor_comment_description);

        doctor_comment = Doctor_Comment_Holder.getData();

        titleText.setText(doctor_comment.getTitle());
        nameText.setText(doctor_comment.getName());
        commentText.setText(doctor_comment.getComment());
    }


}
