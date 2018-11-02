package ca.csualberta.remindme;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RemindActivity extends AppCompatActivity {
    private EditText daysText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remind);

        daysText = (EditText) findViewById(R.id.editTextDays);
        Button sButton = (Button) findViewById(R.id.save);
        Button tButton = (Button) findViewById(R.id.time);

        tButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timepicker = new TimePicker();
                timepicker.show(getSupportFragmentManager(), "time picker");
            }
        });

        sButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                Integer days = Integer.parseInt(daysText.getText().toString());

                //Intent intent = new Intent(MainActivity.this, RemindActivity.class);
                //startActivity(intent);
            }
        });

    }
}
