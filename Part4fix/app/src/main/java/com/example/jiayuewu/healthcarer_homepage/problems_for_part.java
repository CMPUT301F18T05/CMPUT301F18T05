package com.example.jiayuewu.healthcarer_homepage;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class problems_for_part extends AppCompatActivity {
    private EditText partText;
    private String part;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problems_for_part);
        partText = (EditText) findViewById(R.id.part_text);
        part = getIntent().getStringExtra("part");
        partText.setText(part);

        FloatingActionButton addproblem = findViewById(R.id.problem_for_part_add_problem_button);
        addproblem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add_problem_intent = new Intent(problems_for_part.this, add_problem.class);
                add_problem_intent.putExtra("part", part);
                startActivityForResult(add_problem_intent, 0);
            }
        });
    }
}
