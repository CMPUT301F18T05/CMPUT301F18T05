package ca.csualberta.remindme;
// reference https://www.youtube.com/watch?v=yrpimdBRk5Q
// youtube chanel "coding in flow" , "AlarmManager" tutorial

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button rButton = (Button) findViewById(R.id.button);
        rButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);

                //passing the emotion count to new activity
                Intent intent = new Intent(MainActivity.this, RemindActivity.class);
                startActivity(intent);
            }
        });
    }
}
