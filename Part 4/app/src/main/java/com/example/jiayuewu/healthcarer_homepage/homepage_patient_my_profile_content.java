package com.example.jiayuewu.healthcarer_homepage;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class homepage_patient_my_profile_content extends Fragment implements View.OnClickListener {
    private User user;
    private EditText useridText;
    private EditText nameText;
    private EditText emailText;
    private EditText phoneText;
    private Button saveButton;
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
        //saveButton = (Button) rootView.findViewById(R.id.patient_profile_save_button);
        //saveButton.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        // placeholder
                Snackbar.make(v, "Save Button Action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

    }
}
