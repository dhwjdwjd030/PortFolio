package com.dhwjdwjd030.myportfolio;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Handler;
import android.widget.TextView;


public class IntroActivity extends AppCompatActivity {

    private Handler handler;
    TextView text01;
    TextView text02;

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(IntroActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        text01 = (TextView)findViewById(R.id.text01);
        Typeface typeface1 = Typeface.createFromAsset(getAssets(),"fonts/YBMG05.TTF");
        text01.setTypeface(typeface1);

        text02= (TextView)findViewById(R.id.text02);
        Typeface typeface2 = Typeface.createFromAsset(getAssets(),"fonts/ENBLBK.TTF");
        text02.setTypeface(typeface2);
        init();
       // handler.postDelayed(runnable, 1000);
        handler.postDelayed(runnable,3000);
    }

    private void init() {
        handler = new Handler();
    }

    public void onBackPressed(){
        super.onBackPressed();
        handler.removeCallbacks(runnable);
    }

}
