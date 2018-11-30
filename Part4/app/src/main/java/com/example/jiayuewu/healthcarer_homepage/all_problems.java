package com.example.jiayuewu.healthcarer_homepage;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class all_problems extends AppCompatActivity {
    private Problem problem = new Problem();
    private ArrayList<Problem> problemArrayList = new ArrayList<Problem>();
    private ArrayAdapter<Problem> adapter;
    private User user;
    //open the activity_all_problem layout
    //start showing problem history screen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_problems);

        FloatingActionButton all_add_problem = findViewById(R.id.all_add_problem_button);

        all_add_problem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addproblem = new Intent(all_problems.this, add_problem.class);
                startActivity(addproblem);
            }
        });
    }

    /**
     *
     */
    // get user's id from the user data
    // get user's problem history
    // display the history to the search_result listview
    // set onclick in order to let user see the problem details
    // once clkicked, jump to detail's screen (view_patient_problem)
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

        Log.i("hello","" + problemArrayList);
        adapter = new ArrayAdapter<>(this, R.layout.list_item, problemArrayList);
        ListView history = findViewById(R.id.all_problems_lisview);

        history.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        history.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
                Intent viewAndEdit = new Intent(all_problems.this, view_problem.class);
                viewAndEdit.putExtra("position",position);
                startActivity(viewAndEdit);

            }
        });

    }
}
