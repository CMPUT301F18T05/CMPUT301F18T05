package com.example.jiayuewu.healthcarer_homepage;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class add_photos_for_part extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photos_for_part);
        FloatingActionButton upload = findViewById(R.id.add_photos_upload);
        FloatingActionButton save = findViewById(R.id.add_photos_save);
    }
}
