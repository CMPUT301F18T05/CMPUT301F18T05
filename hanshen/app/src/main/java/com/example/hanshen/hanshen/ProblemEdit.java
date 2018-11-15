package com.example.hanshen.hanshen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ProblemEdit extends AppCompatActivity {
    private static final String FILENAME = "file.sav";
    ArrayList<Problem> problemArrayList;
    Problem problem;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.problem_edit);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //reload for new sorted emotionList
        loadFromFile();
    }

    private void updateTextview() {
        //get the old values from the privious info.
        String oldProblem = this.problem.getTitle();
        String oldDscription = this.problem.getDescription();
        Date oldDate = this.problem.getDate();
        TextView Problem = (TextView) findViewById(R.id.oldProblem);
        Problem.setText("Title: " + oldProblem);
        TextView Description = (TextView) findViewById(R.id.oldDscription);
        Description.setText("Description: " + oldDscription);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        TextView Date = (TextView) findViewById(R.id.oldDate);
        Date.setText("Date: " + dateFormat.format(oldDate));
        //update the input values.
        EditText title = findViewById(R.id.newTitle);
        String newTitle = title.getText().toString();
        this.problem.setTitle(newTitle);
        EditText description = findViewById(R.id.newDescription);
        String newDescription = description.getText().toString();
        this.problem.setDescription(newDescription);
        EditText date = findViewById(R.id.newDate);
        String newDate = date.getText().toString();
        @SuppressLint("SimpleDateFormat") DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        try {
            Date newdate = format.parse(newDate);
            this.problem.setDate(newdate);
        } catch (ParseException e) {
            //e.printStackTrace();
            Toast.makeText(this, "Invalid Date, please correct your date", Toast.LENGTH_LONG).show();
        }

    }

    public void saveButton(View view){
        problemArrayList.set(this.position,this.problem);
        saveInFile();
        Toast.makeText(this,"Applied changes",Toast.LENGTH_LONG).show();
        Intent mainactivity = new Intent(this, ProblemHistory.class);
        startActivity(mainactivity);
    }

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(problemArrayList, out);
            out.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Problem>>(){}.getType();
            problemArrayList = gson.fromJson(in,listType);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            problemArrayList = new ArrayList<Problem>();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
