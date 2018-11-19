package com.example.hanshen.hanshen;

/**
 * in the main activity, user can record a emotion with or without a comment
 * user can also choose to view the count of the emotion,then the grogram
 * will active the showCount activity
 * or to view the history of all emotion record, then the program
 * will active the showHistory activity
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
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
import java.util.ArrayList;

public class ProblemCreate extends AppCompatActivity {

    private static final String FILENAME = "problem.sav";
    ArrayList<Problem> problemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem);
        loadFromFile();
    }


    public void createProblem(View view){
        Toast.makeText(this,"Problem has been recorded",Toast.LENGTH_LONG).show();
        EditText description = findViewById(R.id.createDescription);
        String descriptionText = description.getText().toString();
        EditText title = findViewById(R.id.createTitle);
        String titleText = title.getText().toString();
        Problem newEmotion = new Problem(titleText,descriptionText);
        problemArrayList.add(newEmotion);
        saveInFile();
        description.setText("");
        title.setText("");
        Intent emotion_history = new Intent(this, ProblemHistory.class);
        startActivity(emotion_history);
        //adapter.notifyDataSetChanged();
    }


    public void showHistory(View view){
        Intent emotion_history = new Intent(this, ProblemHistory.class);
        startActivity(emotion_history);
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
            problemArrayList = new ArrayList<>();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
}

