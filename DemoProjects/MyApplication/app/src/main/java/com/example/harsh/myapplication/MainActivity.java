package com.example.harsh.myapplication;

import android.icu.math.BigDecimal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    public void buttonClicked(View view) {
        EditText e=(EditText) findViewById(R.id.editText);
        String value= e.getText().toString();
        double val=Double.parseDouble(value);
        double ToEuro=val/1.3845;
        double answer=(double)Math.round(ToEuro*1000d)/1000d;

       // Log.i("Check","My answer is £" + answer);
        Toast.makeText(this, "£ " + answer , Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
