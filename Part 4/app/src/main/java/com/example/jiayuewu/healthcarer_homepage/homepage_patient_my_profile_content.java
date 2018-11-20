/**
 * homepage_patient_my_profile_content
 *This part Patient user can edit and save the information of their profile such as UserID, Name, Email,Phoe.
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

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class homepage_patient_my_profile_content extends Fragment implements View.OnClickListener {
    private User user;
    private EditText useridText;
    private EditText nameText;
    private EditText emailText;
    private EditText phoneText;
    private FloatingActionButton saveButton;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.homepage_patient_my_profile, container, false);
        user = DataHolder.getData();
        useridText = (EditText) rootView.findViewById(R.id.edit_userid_text);
        emailText = (EditText) rootView.findViewById(R.id.edit_email_text);
        phoneText = (EditText) rootView.findViewById(R.id.edit_phone_text);
        nameText = (EditText) rootView.findViewById(R.id.edit_name_text);
        useridText.setText(String.valueOf(user.getUserID()));
        emailText.setText(user.getEmail());
        phoneText.setText(user.getPhoneNumber());
        nameText.setText(user.getName());
        // todo this is not working, need to find proper way to get this working
        saveButton = (FloatingActionButton) rootView.findViewById(R.id.patient_profile_save_button);
        saveButton.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        // placeholder
        Snackbar.make(v, "Contact Information Saved", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

        elasticSearch.deleteUserTask task
                = new elasticSearch.deleteUserTask();
        task.execute(user.getUserID());

        String u,e,p,n;
        u = useridText.getText().toString();
        e = emailText.getText().toString();
        p = phoneText.getText().toString();
        n = nameText.getText().toString();

        //User user2 = new User(Integer.parseInt(u),n,e,p,user.getRole());
        user.setEmail(e);
        user.setUserID(Integer.parseInt(u));
        user.setName(n);
        user.setPhoneNumber(p);

        DataHolder.setData(user);
        try {
            Thread.sleep(1000);
        } catch (Exception el) {

        }

        //userArrayList.add(user);
        //todo add the list to local or ES using controller
        elasticSearch.addUserTask addTweetsTask
                = new elasticSearch.addUserTask();
        addTweetsTask.execute(user);

    }
}
