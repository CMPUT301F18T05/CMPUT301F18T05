package com.example.hanshen.hanshen;

/**
 * for the activity, the program let the user change any component of the emotion
 * after the user apply the changes, it will change the emotion record
 * after the user delete the emotion record, the selected emotion will be deleted from the history
 * whenever user apply or delete emotions, the program will activity main activity
 */

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


public class ViewAndEdit extends AppCompatActivity {

    private static final String FILENAME = "file.sav";
    ArrayList<Problem> problemArrayList;
    Problem emotion;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_edit);
        Intent intent = getIntent();
        this.position = intent.getIntExtra("position",0);
        loadFromFile();
        this.emotion = problemArrayList.get(this.position);
        loadOldInfo();
    }

    @SuppressLint("SetTextI18n")
    private void loadOldInfo(){

        String oldEmotion = this.emotion.getTitle();
        String oldComment = this.emotion.getDescription();
        Date oldDate = this.emotion.getDate();
        TextView emotionPromote = (TextView)findViewById(R.id.oldEmotion);
        emotionPromote.setText("Old Emotion: "+oldEmotion);

        TextView commentPromote = (TextView)findViewById(R.id.oldComment);
        commentPromote.setText("Old Comment: "+oldComment);

        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        TextView datePromote = (TextView)findViewById(R.id.oldDate);
        datePromote.setText("Old Date: "+dateFormat.format(oldDate));

    }
    public void updateComment(View view){
        EditText text = (EditText) findViewById(R.id.updatedescription);
        String newComment = text.getText().toString();
        this.emotion.setDescription(newComment);
        Toast.makeText(this,"Comment changed",Toast.LENGTH_LONG).show();
    }
    public void updateDate(View view){
        EditText text = (EditText) findViewById(R.id.updatedate);
        String newDate = text.getText().toString();

        @SuppressLint("SimpleDateFormat") DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        try {
            Date date = format.parse(newDate);
            this.emotion.setDate(date);
            Toast.makeText(this,"Date changed",Toast.LENGTH_LONG).show();
        } catch (ParseException e) {
            //e.printStackTrace();
            Toast.makeText(this,"Invalid Date, please correct your date",Toast.LENGTH_LONG).show();
        }
    }
    public void applyChange(View view){
        problemArrayList.set(this.position,this.emotion);
        saveInFile();
        Toast.makeText(this,"Applied changes",Toast.LENGTH_LONG).show();
        Intent back = new Intent(this, ProblemHistory.class);
        startActivity(back);
    }
    public void deleteEmotion(View view){
        problemArrayList.remove(this.emotion);
        saveInFile();
        Toast.makeText(this,"Deleted this emotion",Toast.LENGTH_LONG).show();
        Intent back = new Intent(this, ProblemHistory.class);
        startActivity(back);
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
            problemArrayList = new ArrayList<>();
        }
    }

}
