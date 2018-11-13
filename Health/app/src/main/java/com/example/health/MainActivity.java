package com.example.health;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;




public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button Login;
    Button NewProfile ;
    ImageView Logo;
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login = findViewById(R.id.Login);
        NewProfile  = findViewById(R.id.NewProfile);
        Logo  = findViewById(R.id.Logo);
        Login .setOnClickListener(this);
        NewProfile .setOnClickListener(this);

        ImageView myImageView = (ImageView) findViewById(R.id.Logo);

    }

    @Override
    public void onClick( View v ) {
        if(v.getId()== R.id.button_reg)
        {
            startActivity(new Intent(MainActivity.this,Signup.class));

        }

    }
}

