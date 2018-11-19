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
import java.util.Collections;
import java.util.Comparator;

public class RecordHistory extends AppCompatActivity {
    private static final String FILENAME = "record.sav";
    ArrayList<Record> recordArrayList;
    ArrayList<Problem> problemArrayList;
    ArrayAdapter<Record> adapter;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_history);
        Intent intent = getIntent();
        this.position = intent.getIntExtra("position",0);
        loadFromFile();
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadFromFile();
        sortRecords();
        saveInFile();
        //reload for new sorted emotionList
        loadFromFile();
        showdetail();
    }

    public void sortRecords(){
        Collections.sort(recordArrayList, new Comparator<Record>() {
            public int compare(Record first, Record next) {
                return first.getDate().compareTo(next.getDate());
            }
        });
    }
    private void showdetail(){
        adapter = new ArrayAdapter<>(this, R.layout.list_item, recordArrayList);
        ListView history = findViewById(R.id.recordHistory);
        history.setAdapter(adapter);
        history.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
                Intent intent = new Intent(RecordHistory.this, RecordEdit.class);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });
    }
    public void delete(View view){
        recordArrayList = new ArrayList<Record>();
        saveInFile();
        Intent back = new Intent(this, ProblemCreate.class);
        startActivity(back);
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
            //e.printStackTrace();
            recordArrayList = new ArrayList<Record>();

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
