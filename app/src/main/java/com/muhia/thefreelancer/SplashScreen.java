package com.muhia.thefreelancer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    private static int timeout=4000;
    ImageView imga,imgb,imgc;
    Animation frombottom,fromtop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imga=findViewById(R.id.ic_a);
        imgb=findViewById(R.id.ic_b);
        imgc=findViewById(R.id.ic_c);


        frombottom= AnimationUtils.loadAnimation(SplashScreen.this,R.anim.myanimation);
        fromtop=AnimationUtils.loadAnimation(SplashScreen.this,R.anim.fromtop);
        imga.setAnimation(fromtop);
        imgb.setAnimation(frombottom);
        imgc.setAnimation(frombottom);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        },timeout);
    }
}
