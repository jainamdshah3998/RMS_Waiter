package com.example.waiterside;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class splashActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("RMS",MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent intent;
                String mobile=sharedPreferences.getString("waitormobilenumer","");
                String s=sharedPreferences.getString("login","");

                if(mobile!="")
                {

                    intent=new Intent(splashActivity.this,TableActivity.class);
                }
                else
                {


                    intent=new Intent(splashActivity.this,LoginActivity.class);
                }


                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();

            }
        },1000);

    }
}