package com.kunal.notesappmvvm.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.kunal.notesappmvvm.MainActivity;
import com.kunal.notesappmvvm.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //HIDE ACTION BAR
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //code exe

                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }
        }, 2000);

    }
}