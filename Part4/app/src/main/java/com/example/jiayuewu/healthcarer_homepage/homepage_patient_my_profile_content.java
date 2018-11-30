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

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Random;

public class homepage_patient_my_profile_content extends Fragment implements View.OnClickListener {
    private User user;
    private EditText useridText;
    private EditText nameText;
    private EditText emailText;
    private EditText phoneText;
    private FloatingActionButton saveButton;
    private Button getCodeButton;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.homepage_patient_my_profile, container, false);
        user = DataHolder.getData();
        useridText = (EditText) rootView.findViewById(R.id.edit_userid_text);
        emailText = (EditText) rootView.findViewById(R.id.edit_email_text);
        phoneText = (EditText) rootView.findViewById(R.id.edit_phone_text);
        nameText = (EditText) rootView.findViewById(R.id.edit_name_text);
        getCodeButton = rootView.findViewById(R.id.transfer_code_button);
        getCodeButton.setOnClickListener(this);
        useridText.setText(String.valueOf(user.getUserID()));
        emailText.setText(user.getEmail());
        phoneText.setText(user.getPhoneNumber());
        nameText.setText(user.getName());
        // todo this is not working, need to find proper way to get this working
        saveButton = (FloatingActionButton) rootView.findViewById(R.id.patient_profile_save_button);
        saveButton.setOnClickListener(this);
        return rootView;
    }

    public Integer generateCode(Integer id) {
        elasticSearch.getTransferTask task
                = new elasticSearch.getTransferTask();
        Integer code, userid;
        Random Number;
        transferObject t;
        ArrayList<transferObject> idArrayList = new ArrayList<transferObject>();

        while (true) {

            Number = new Random();
            code = Number.nextInt(100);
            task.execute(code);

            try {
                idArrayList = task.get();

            }	catch (Exception e) {
                Log.e("Error", "Failed to get the user id out of the async object.");
            }
            try {
                idArrayList.get(0).equals(null);
            } catch (Exception e) {
                break;
            }
        }
        transferObject tt = new transferObject(id,code);
        elasticSearch.setTransferTask task2
                = new elasticSearch.setTransferTask();
        task2.execute(tt);
        return code;
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.transfer_code_button :
                // transfer button clicked
                Integer code;
                code = generateCode(user.getUserID());
                final AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
                alertDialog.setTitle("Trasfer code generated");
                alertDialog.setMessage("Trasfer code is " + code);
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

            case R.id.patient_profile_save_button :
                // save button clicked
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
                try {
                    user.setUserID(Integer.parseInt(u));
                } catch (Exception_User_ID_Too_Short uid) {
                    Snackbar.make(v, "UserID must only contain digits. NO letters please.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }
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
                // similarly for other buttons
            }
    }

}
