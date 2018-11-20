package com.example.jiayuewu.healthcarer_homepage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class all_problems extends AppCompatActivity {
    private Problem problem = new Problem();
    private ArrayList<Problem> problemArrayList = new ArrayList<>();
    private ArrayAdapter<Problem> adapter;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_problems);
    }

    /**
     *
     */
    @Override
    protected void onStart() {
        super.onStart();
        user = DataHolder.getData();
        Integer ID = user.getUserID();
        elasticSearch.getProblemsTask getProblemsTask = new elasticSearch.getProblemsTask();
        getProblemsTask.execute(ID);

        try{
            problemArrayList = getProblemsTask.get();
        } catch (Exception e){
            Log.e("Error", "Failed to get the problem history out of the async object.");
        }

        adapter = new ArrayAdapter<>(this, R.layout.activity_all_problems, problemArrayList);
        ListView history = findViewById(R.id.search_result_lisview);
        history.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        history.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
                Intent viewAndEdit = new Intent(all_problems.this, view_patient_problem.class);
                viewAndEdit.putExtra("position",position);
                startActivity(viewAndEdit);

            }
        });
    }
}
