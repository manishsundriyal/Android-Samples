package com.example.acer.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioGroup;

import com.example.acer.myapplication.Com.Commerce;
import com.example.acer.myapplication.Hum.Humanities;
import com.example.acer.myapplication.Sci.stream;

public class choose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    public void onRadioButtonClicked(View view) {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        int id = radioGroup.getCheckedRadioButtonId();
        switch (id) {
            case R.id.radioButton:
                Intent intent = new Intent(choose.this, stream.class);
                startActivity(intent);
// Cavemen win
                break;
            case R.id.radioButton2:
                Intent intent1 = new Intent(choose.this,Commerce.class);
                startActivity(intent1);

// Astronauts win
                break;
            case R.id.radioButton3:
                Intent intent2 = new Intent(choose.this,Humanities.class);
                startActivity(intent2);
                break;


        }
    }
}
