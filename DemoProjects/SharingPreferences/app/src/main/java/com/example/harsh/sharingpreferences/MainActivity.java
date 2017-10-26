package com.example.harsh.sharingpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences=this.getSharedPreferences("com.example.harsh.sharingpreferences", Context.MODE_PRIVATE);

        ArrayList<String> arrayList= new ArrayList<>();
        arrayList.add("Rob");
        arrayList.add("Ralphie");
        arrayList.add("Tommy");
        arrayList.add("Rsjnf");
        try {
            sharedPreferences.edit().putString("family",ObjectSerializer.serialize(arrayList)).apply();


        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> newFamily= new ArrayList<>();
        try {
            newFamily=(ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("family",ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.i("newFamily",newFamily.toString());

    }
}
