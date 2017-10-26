package com.example.harsh.reminders;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextToSpeech tts;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText) findViewById(R.id.editText);
        button=(Button) findViewById(R.id.button);
    }/*
    public void onClick(View view){
        tts=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR){
                    tts.setLanguage(Locale.UK);
                    String toSpeak=editText.getText().toString();
                    Log.i("Testing",toSpeak);
                    tts.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                }
            }

        });

    }*/
}
