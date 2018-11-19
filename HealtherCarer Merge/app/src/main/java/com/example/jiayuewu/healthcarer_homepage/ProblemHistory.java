package com.example.jiayuewu.healthcarer_homepage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

public class ProblemHistory extends AppCompatActivity {

    private static final String FILENAME = "problem.sav";
    ArrayList<Problem> emotionList;
    ArrayAdapter<Problem> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_history);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //reload for new sorted emotionList
        loadFromFile();
        showProblem();
    }


    //show all the history to the screen
    private void showProblem(){
        adapter = new ArrayAdapter<>(this, R.layout.list_item, emotionList);
        ListView history = findViewById(R.id.problemHistory);
        history.setAdapter(adapter);
        history.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
                Intent viewAndEdit = new Intent(ProblemHistory.this, RecordHistory.class);
                viewAndEdit.putExtra("position",position);
                startActivity(viewAndEdit);
            }
        });
    }

    public void clearAll(View view){
        emotionList = new ArrayList<Problem>();
        saveInFile();
        Intent back = new Intent(this, ProblemCreate.class);
        startActivity(back);
    }
    public void addProblem(View view){
        Intent back = new Intent(this, ProblemCreate.class);
        startActivity(back);
    }



    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Problem>>(){}.getType();
            emotionList = gson.fromJson(in,listType);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            emotionList = new ArrayList<Problem>();

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
            gson.toJson(emotionList, out);
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
