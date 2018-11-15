package com.example.hanshen.hanshen;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    private static final String FILENAME = "file.sav";
    ArrayList<Problem> problemArrayList;
    ArrayAdapter<Problem> adapter;
    private ListView problemHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.problem_history);
        loadFromFile();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //reload for new sorted emotionList
        loadFromFile();
        adapter = new ArrayAdapter<>(this, R.layout.list_item, problemArrayList);
        problemHistory = findViewById(R.id.probHistory);
        problemHistory.setAdapter(adapter);
        problemHistory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
                Intent viewAndEdit = new Intent(ProblemHistory.this, ProblemEdit.class);
                viewAndEdit.putExtra("position", position);
                startActivity(viewAndEdit);
            }
        });
    }

    public void recordNewButton(View view) {
        Intent edit = new Intent(this, ProblemEdit.class);
        startActivity(edit);
    }

    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Problem>>() {
            }.getType();
            problemArrayList = gson.fromJson(in, listType);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            problemArrayList = new ArrayList<Problem>();
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