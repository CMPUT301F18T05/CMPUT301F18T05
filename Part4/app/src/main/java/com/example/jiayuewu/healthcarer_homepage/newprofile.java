/**
 * newprofile
 * This part user can create a account which includes userID, Name, Email, Phone and the roles
 * such as Patient or Doctor. Then user can use save button to save their account in our ES and
 * go to the "login" part.
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

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class newprofile extends AppCompatActivity {

    private Spinner roleSpinner;
    private EditText useridText;
    private EditText nameText;
    private EditText emailText;
    private EditText phoneText;
    //private ArrayList<User> userArrayList = new ArrayList<User>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newprofile);
        setTitle("New Profile");
        roleSpinner = (Spinner) findViewById(R.id.role_spinner);

        /** setting up the spinner with adapter to update the view as user selects */
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(newprofile.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.role_array));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roleSpinner.setAdapter(myAdapter);

        FloatingActionButton registerButton = (FloatingActionButton) findViewById(R.id.register_button);
        useridText = (EditText) findViewById(R.id.userid_text);
        emailText = (EditText) findViewById(R.id.email_text);
        phoneText = (EditText) findViewById(R.id.phone_text);
        nameText = (EditText) findViewById(R.id.name_text);

        registerButton.setOnClickListener(new View.OnClickListener() {

           public void onClick(View v) {
                setResult(RESULT_OK);
                String uk = useridText.getText().toString();
                Integer userid = 0 + Integer.parseInt(uk);

                Log.w("USER ID ASKDASDKBAFBGAG", "" + userid);

                String name = nameText.getText().toString();
                String phone = phoneText.getText().toString();
                String email = emailText.getText().toString();

                String roleString = roleSpinner.getSelectedItem().toString();

                User user = new User(userid,name,email,phone,roleString);
                //userArrayList.add(user);
                //todo add the list to local or ES using controller
               elasticSearch.addUserTask addTweetsTask
                       = new elasticSearch.addUserTask();
               addTweetsTask.execute(user);

               Snackbar.make(v, "New user created", Snackbar.LENGTH_LONG)
                       .setAction("Action", null).show();
            }
        });
    }
}
