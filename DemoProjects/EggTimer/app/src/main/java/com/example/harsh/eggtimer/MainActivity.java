package com.example.harsh.eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView timerTextView;
    SeekBar timerSeekBar;
    Button button;
    CountDownTimer cd;
    boolean CounterIsActive=false;

    public void updateTimer(int secLeft){

        int minutes= (int) secLeft/60;
        int seconds=(int) secLeft%60;
        String secondString=Integer.toString(seconds);
        if(seconds<=9)
            secondString="0" + Integer.toString(seconds);
        timerTextView.setText(Integer.toString(minutes) + ":" + secondString);
    }


    public void resetTimer(){
        timerTextView.setText("0:30");
        timerSeekBar.setProgress(30);
        cd.cancel();
        button.setText("GO!");
        timerSeekBar.setEnabled(true);
        CounterIsActive=true;
    }
    public void controlTimer(View view) {

        if (CounterIsActive == false) {
            updateTimer(timerSeekBar.getProgress());
            button.setText("Stop");
            CounterIsActive = true;
            timerSeekBar.setEnabled(false);
            cd=new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100, 1000) {

                @Override
                public void onTick(long l) {
                    updateTimer((int) l / 1000);
                }

                @Override
                public void onFinish() {
                    timerTextView.setText("0:00");
                    MediaPlayer mplayer = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                    mplayer.start();
                    resetTimer();
                }
            }.start();
        }
        else{
                resetTimer();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button) findViewById(R.id.controllerButton);

        timerSeekBar=(SeekBar) findViewById(R.id.timer);
        timerTextView=(TextView) findViewById(R.id.timerTextView);
        timerSeekBar.setMax(600);
        timerSeekBar.setProgress(30);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateTimer(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
