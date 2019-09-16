package com.muhia.thefreelancer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button maina,mainb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maina=findViewById(R.id.btnmaina);
        mainb=findViewById(R.id.btnmainb);

        maina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sign= new Intent(MainActivity.this,SignupActivity.class);
                startActivity(sign);

            }

        });

        mainb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login=new Intent(MainActivity.this,LogInActivity.class);
                startActivity(login);
            }
        });
    }
}
