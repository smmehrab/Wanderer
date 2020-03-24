package com.example.wanderers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class LoadingScreen extends AppCompatActivity {

    private int progress;
    private ProgressBar progressBar;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_loading_screen);

        logo = (ImageView) findViewById(R.id.welcome_screen_logo);
        progressBar = (ProgressBar) findViewById(R.id.welcome_screen_progress_bar);

        Thread thread = new Thread(){
            @Override
            public void run() {
                doWork();
                startApp();
            }
        };

        thread.start();
    }

    public void startApp(){
        Intent intent = new Intent(LoadingScreen.this, CountriesActivity.class);
        startActivity(intent);
        finish();
    }

    public void doWork(){
        for(progress=20;progress<=100;progress+=80) {
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
