package com.example.jiayuewu.healthcarer_homepage;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
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

        Button saveButton = findViewById(R.id.add_record_save_button);


        this.newRecord.setComment("sss");


        saveButton.setOnClickListener(new View.OnClickListener() {


            @Override

            public void onClick(View v) {
                context = add_record.this;

                // Todo: Need to save the record to elastic search

                // Do a bunch of checks.


//            try {
//                newRecord.setComment();
//            }



            }
        });






    }
}
