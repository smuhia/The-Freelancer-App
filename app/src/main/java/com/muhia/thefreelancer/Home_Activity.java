package com.muhia.thefreelancer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Home_Activity extends AppCompatActivity {
    CardView reachcrd,webcrd,hirecrd,fundcrd,advertisecrd,projectcrd;
    ImageButton exit;
    FirebaseAuth mFirebaseauth;
    AlertDialog.Builder builder;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);
        exit= findViewById(R.id.exit_btn);
        reachcrd=findViewById(R.id.reach_out);
        webcrd=findViewById(R.id.website);
        hirecrd=findViewById(R.id.hire_card);
        fundcrd=findViewById(R.id.fund_card);
        advertisecrd=findViewById(R.id.advert_card);
        projectcrd=findViewById(R.id.project_card);
        builder=new AlertDialog.Builder(this);


        reachcrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","smuhia19@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "I need Help");
                startActivity(Intent.createChooser(emailIntent, "Tuma email"));

            }
        });
       // webcrd.setOnClickListener(new View.OnClickListener() {
            //@Override
           // public void onClick(View view) {

           // }
       // });

        hirecrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hire= new Intent(Home_Activity.this,HireActivity.class);
                startActivity(hire);
            }
        });
        fundcrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fund=new Intent(Home_Activity.this,ScrollActivity.class);
                startActivity(fund);

            }
        });
        advertisecrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent advert= new Intent(Home_Activity.this,AdvertiseActivity.class);
                startActivity(advert);
            }
        });
        projectcrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent prj= new Intent(Home_Activity.this,ProjectActivity.class);
                startActivity(prj);

            }
        });



        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intmain = new Intent(Home_Activity.this,MainActivity.class);
                startActivity(intmain);

            }
        });

        public void CloseApp (View){
        builder.setMessage("Do you want to Log Out")
                .setCancelable(false)
                .setPositiveButton("Yes close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        Toast.makeText(Home_Activity.this, "You closed the app", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        Toast.makeText(Home_Activity.this, "thanks for sticking around", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog alertDialog=builder.create();
        alertDialog.setTitle("Close App");
        alertDialog.show();


    }
}}
