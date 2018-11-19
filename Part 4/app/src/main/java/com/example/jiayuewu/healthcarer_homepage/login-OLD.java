//package com.example.jiayuewu.healthcarer_homepage;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//
//import java.util.ArrayList;
//import java.util.Calendar;
//
//public class login extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        Button login = findViewById(R.id.login_login_button);
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent patient_intent = new Intent(login.this, homepage_patient.class);
//                startActivityForResult(patient_intent, 0);
//                //Intent doctor_intent = new Intent(login.this, homepage_doctor.class);
//                //startActivityForResult(doctor_intent, 0);
//            }
//        });
//
//        addProblem();
//
//        getAllProblems();
//
//    }
//
//    public void getAllProblems() {
//        elasticSearch.GetProblemsTask getTweetsTask =
//                new elasticSearch.GetProblemsTask();
//
//        Integer userID = 1;
//        getTweetsTask.execute(userID);
//
//        try {
//            Log.w("Got", "think");
//            ArrayList<Problem> list = getTweetsTask.get();
//            Log.w("GOT", ""+ list);
//
//        } catch (Exception e) {
//            Log.w("You failed", "D");
//        }
//    }
//
//    public void addProblem() {
//        Problem problem = new Problem(23,23,"wew", Calendar.getInstance(),"WEWE","WE");
//
//        elasticSearch.AddProblemTask addTweetsTask =
//                new elasticSearch.AddProblemTask();
//
//        try {
//            addTweetsTask.execute(problem);
//            Log.w("Added", "D");
//
//        } catch (Exception e) {
//            Log.w("You failed", "D");
//        }
//
//    }
//
//}
