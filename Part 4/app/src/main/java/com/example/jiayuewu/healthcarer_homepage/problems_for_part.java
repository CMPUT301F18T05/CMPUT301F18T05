package com.example.jiayuewu.healthcarer_homepage;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class problems_for_part extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problems_for_part);
        FloatingActionButton addproblem = findViewById(R.id.problem_for_part_add_problem_button);
        addproblem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add_problem_intent = new Intent(problems_for_part.this, add_problem.class);
                startActivityForResult(add_problem_intent, 0);
            }
        });
    }
}
