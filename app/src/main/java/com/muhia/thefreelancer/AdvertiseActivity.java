package com.muhia.thefreelancer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class AdvertiseActivity extends AppCompatActivity {
    EditText Fname,Lname,Email,Age,Des,Country,City,ZIP;
    ImageButton Submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertise);

        Fname=findViewById(R.id.fname);
        Lname=findViewById(R.id.lname);
        Email=findViewById(R.id.email);
        Age=findViewById(R.id.age);
        Des=findViewById(R.id.des);
        Country=findViewById(R.id.country);
        City=findViewById(R.id.city);
        ZIP=findViewById(R.id.zip);
        Submit=findViewById(R.id.btnsubmit);


        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                messages("Success","Information saved successfully");
                Fname.setText("");
                Lname.setText("");
                Email.setText("");
                Age.setText("");
                Des.setText("");
                Country.setText("");
                City.setText("");
                ZIP.setText("");

            }
        });

    }
    //message display function
    protected void messages(String title,String messeages) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(messeages);
        builder.create().show();


    }


}