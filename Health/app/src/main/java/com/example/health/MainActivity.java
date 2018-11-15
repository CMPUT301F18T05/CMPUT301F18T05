package com.example.health;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;




public class MainActivity extends AppCompatActivity{
    Button NewProfile ;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button Login= (Button)findViewById(R.id.btn_Login );
        final Button NewProfile= (Button)findViewById(R.id.btn_NewProfile );
        NewProfile .setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick( View view ) {
                Intent Newprofile= new Intent(MainActivity.this,Signup.class );
                MainActivity.this.startActivity(Newprofile );
            }
        });



    }
}

