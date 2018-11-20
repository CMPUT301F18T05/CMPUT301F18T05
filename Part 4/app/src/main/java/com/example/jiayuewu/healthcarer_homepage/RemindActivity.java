/**
 * RemindActivity
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

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class RemindActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{
    private EditText daysText;
    private String duration;
    private NotificationHelper mNotificationHelper;
    private TextView mTextView;
    private Calendar c = Calendar.getInstance();
    /**
     * create the basic interface for user to set notifications for problem
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remind);

        daysText = (EditText) findViewById(R.id.editTextDays);
        mTextView = (TextView) findViewById(R.id.setTextView);
        Button sButton = (Button) findViewById(R.id.save);
        Button tButton = (Button) findViewById(R.id.time);
        Button cButton = (Button) findViewById(R.id.cancel);
        mNotificationHelper = new NotificationHelper(this);


        tButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timepicker = new TimePicker();
                timepicker.show(getSupportFragmentManager(), "time picker");
            }
        });

        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelReminder();
            }
        });

        sButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                duration = daysText.getText().toString();

                String title = "Reminder";
                String message = "Do not forget to take photo for the problem";
                String message2 = "I am god, evn this is working";
                String setText = "Reminder set for: ";
                updateTimeText(c,setText);
                startReminder(c,title,message,duration);
                //startReminder2(c,title,message2,duration);

            }
        });

    }

    @Override
    public void onTimeSet(android.widget.TimePicker view, int hour, int min) {
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, min);
        c.set(Calendar.SECOND, 0);
        String text = "Time set for: ";
        updateTimeText(c,text);
    }

    private void updateTimeText(Calendar c, String timeText) {
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());
        mTextView.setText(timeText);
    }

    private void startReminder(Calendar c, String title, String message, String duration) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        intent.putExtra("title", title);
        intent.putExtra("message", message);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1,intent,0);

        //if (c.before(Calendar.getInstance())) {
        //     c.add(Calendar.DATE, Integer.parseInt(duration));
        //}
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),AlarmManager.INTERVAL_HOUR * Integer.parseInt(duration),pendingIntent);
    }
    //    private void startReminder2(Calendar c, String title, String message, String duration) {
//        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//        Intent intent = new Intent(this, AlertReceiver.class);
//        intent.putExtra("title", title);
//        intent.putExtra("message", message);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 2,intent,0);
//
//        //if (c.before(Calendar.getInstance())) {
//        //     c.add(Calendar.DATE, Integer.parseInt(duration));
//        //}
//        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),((AlarmManager.INTERVAL_FIFTEEN_MINUTES / 15)/60) * Integer.parseInt(duration),pendingIntent);
//    }
    private void cancelReminder() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1,intent,0);

        alarmManager.cancel(pendingIntent);
        mTextView.setText("Reminder canceled");
    }

    //public void sendOnChannel(String title, String message) {
    //    NotificationCompat.Builder nb = mNotificationHelper.getChannelNotification(title, message);
    //    mNotificationHelper.getManager().notify(1, nb.build());
    //}
}
