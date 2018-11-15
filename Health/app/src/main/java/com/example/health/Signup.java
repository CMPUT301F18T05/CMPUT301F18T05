package com.example.health;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Type;
import java.util.jar.Attributes;

public class Signup extends AppCompatActivity{
    TextView SignUp;
    TextView Roles;
    Spinner mType;
    EditText UserName;
    EditText ID;
    EditText UserEmail;
    EditText UserPhone;
    Button btn_save;


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        SignUp = findViewById(R.id.textView_SignUp);
        Roles = findViewById(R.id.Role);
        mType  = findViewById(R.id.Type);
        UserName = findViewById(R.id.Name);
        ID = findViewById(R.id.UserId );
        UserEmail = findViewById(R.id.Email);
        UserPhone = findViewById(R.id.Phone);
        btn_save = findViewById(R.id.save);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.memberTypes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mType.setAdapter(adapter);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                Intent Main= new Intent(Signup.this,MainActivity .class );
                Signup.this.startActivity(Main );
            }
        });



    }
}

