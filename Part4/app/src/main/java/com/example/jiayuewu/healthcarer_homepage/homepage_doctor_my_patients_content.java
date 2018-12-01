/**
 * homepage doctor my patients content
 * This part Doctor user can watch a list of their patients. They can search by key words(does not be implemented)
 *
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
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class homepage_doctor_my_patients_content extends Fragment{
    public Button sbutton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.homepage_doctor_my_patients, container, false);
        sbutton = rootView.findViewById(R.id.search_button);

        sbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // placeholder
                Snackbar.make(v, "Search Button Action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ListView patients = rootView.findViewById(R.id.patients_listview);
        List<String> test_array_list = new ArrayList<String>();
        test_array_list.add("foo");
        test_array_list.add("bar");

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                homepage_doctor_my_patients_content.this.getActivity(),
                android.R.layout.simple_list_item_1,
                test_array_list );

        patients.setAdapter(arrayAdapter);
        patients.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
                Intent vp = new Intent(homepage_doctor_my_patients_content.this.getActivity(), view_patient.class);
                vp.putExtra("position",position);
                startActivity(vp);

            }
        });

        FloatingActionButton addpatient = rootView.findViewById(R.id.add_patient_button);
        addpatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ap = new Intent(homepage_doctor_my_patients_content.this.getActivity(), add_patient.class);
                startActivity(ap);
            }
        });


        return rootView;
    }
}
