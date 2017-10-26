package com.example.acer.myapplication.Sci;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.acer.myapplication.R;


public class stream extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




    }
    public void click_me(View view)
    { Intent intent=new Intent(stream.this,Career_list.class);
        startActivity(intent);

    }
    public void click_me1(View view)
    {
        Intent intent=new Intent(stream.this,Business.class);
        startActivity(intent);

    }
    public void click_me2(View view)
    {
        Intent intent=new Intent(stream.this,Scientific.class);
        startActivity(intent);

    }
    public void click_me3(View view)
    {
        Intent intent=new Intent(stream.this,Aesthetic.class);
        startActivity(intent);

    }
    public void click_me4(View view)
    {
        Intent intent=new Intent(stream.this,Social.class);
        startActivity(intent);

    }
    public void click_me5(View view)
    {
        Intent intent=new Intent(stream.this,Clerical.class);
        startActivity(intent);
    }



    }
