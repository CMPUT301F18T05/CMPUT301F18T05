package com.example.jiayuewu.healthcarer_homepage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class add_problem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_problem);
        Button rButton = (Button) findViewById(R.id.button);
        rButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);

                //passing the emotion count to new activity
                Intent intent = new Intent(add_problem.this, RemindActivity.class);
                add_problem.this.startActivity(intent);
            }
        });
    }
}
