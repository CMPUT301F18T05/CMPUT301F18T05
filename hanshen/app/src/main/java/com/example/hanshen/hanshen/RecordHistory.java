package com.example.hanshen.hanshen;

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
import java.util.Collections;
import java.util.Comparator;

public class RecordHistory extends AppCompatActivity {
    private static final String FILENAME = "file.sav";
    ArrayList<Record> recordArrayList;
    ArrayAdapter<Record> adapter;
    private ListView recordHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.problem_history);
        loadFromFile();
    }
    @Override
    protected void onStart() {
        super.onStart();
        loadFromFile();
        timestamp();
        saveInFile();
        //reload for new sorted emotionList
        loadFromFile();
        adapter = new ArrayAdapter<>(this, R.layout.list_item, recordArrayList);
        recordHistory = findViewById(R.id.probHistory);
        recordHistory.setAdapter(adapter);
        recordHistory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
                Intent viewAndEdit = new Intent(RecordHistory.this, RecordEdit.class);
                viewAndEdit.putExtra("position",position);
                startActivity(viewAndEdit);
            }
        });

    }

    public void recordNewButton(View view){
        recordArrayList = new ArrayList<Record>();
        saveInFile();
        Intent back = new Intent(this, ProblemEdit.class);
        startActivity(back);
    }

    public void timestamp(){
        Collections.sort(recordArrayList, new Comparator<Record>() {
            public int compare(Record record1, Record record2) {
                return record1.getDate().compareTo(record2.getDate());
            }
        });
    }

    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Problem>>(){}.getType();
            recordArrayList = gson.fromJson(in,listType);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            recordArrayList = new ArrayList<>();
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
            gson.toJson(recordArrayList, out);
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
