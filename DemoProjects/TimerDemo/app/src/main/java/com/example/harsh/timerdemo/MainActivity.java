package com.example.harsh.timerdemo;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountDownTimer cd = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                Log.i("hh", "5 seconds passed");
            }

            @Override
            public void onFinish() {
                    Log.i("fin","finished!");
            }
        }.start();
    }
        /*final Handler handler=new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                //Code runs every second
                Log.i("info","After every second");

                handler.postDelayed(this, 5000);
            }
        };
        handler.post(run);
    }*/
}
