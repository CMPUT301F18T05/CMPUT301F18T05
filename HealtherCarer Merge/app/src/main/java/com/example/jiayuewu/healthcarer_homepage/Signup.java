package com.example.jiayuewu.healthcarer_homepage;

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

public class Signup extends AppCompatActivity implements View.OnClickListener {
    TextView SignUp;
    TextView Roles;
    Spinner mType;
    EditText UserName;
    EditText ID;
    EditText UserEmail;
    EditText UserPhone;
    Button btn_save;
    TextView WarningText;


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        WarningText=findViewById(R.id.textView_warning);
        SignUp = findViewById(R.id.textView_SignUp);
        Roles = findViewById(R.id.Role);
        mType  = findViewById(R.id.Type);
        UserName = findViewById(R.id.Name);
        ID = findViewById(R.id.UserId );
        UserEmail = findViewById(R.id.Email);
        UserPhone = findViewById(R.id.Phone);
        btn_save = findViewById(R.id.save);
        btn_save.setOnClickListener(this);
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

    @Override
    public void onClick( View view ) {
        String mtype = mType.getSelectedItem().toString();
        String username = UserName .getText().toString();
        String id = ID.getText().toString();
        String userphone = UserPhone .getText().toString();
        String useremail = UserEmail .getText().toString();
        if(view.getId()==R.id.save){
            if (mtype.equals("Patient") && username!="" && id!="" && userphone!="" && useremail !="")
            {
                startActivity(new Intent(Signup.this, MainActivity.class));
            }
            else if(mtype.equals("CareProvider") && username!="" && id!="" && userphone!="" && useremail !="")
            {
                startActivity(new Intent(Signup.this, MainActivity.class));
            }
            else if (username .equals(""))
            {
                WarningText.setText(R.string.Fail);
            }
            else if (id.equals(""))
            {
                WarningText.setText(R.string.Fail);
            }
            else if (userphone.equals(""))
            {
                WarningText.setText(R.string.Fail);
            }
            else if (useremail.equals(""))
            {
                WarningText.setText(R.string.Fail);
            }

        }


    }
}

