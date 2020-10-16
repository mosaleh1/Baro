package com.runcode.baro.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.runcode.baro.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
          @Override
          public void run() {
              Intent intent = new Intent(SplashActivity.this, MainActivity.class);
              startActivity(intent);
              finish();
          }
        }, 3000);

    }
}