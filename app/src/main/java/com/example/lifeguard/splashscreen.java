package com.example.lifeguard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        Animation fadeIn = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        ImageView splashLogo = findViewById(R.id.splash_logo);
        splashLogo.startAnimation(fadeIn);

        Animation textAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up_fade_in);
        TextView yourTextView = findViewById(R.id.textid);  // Replace with your actual TextView ID
        yourTextView.startAnimation(textAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splashscreen.this,MainActivity.class);
                startActivity(intent);

                finish();
            }
        },5000);
    }
}