package com.example.harsh.memorableplaces;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    static ArrayList<LatLng> locations=new ArrayList<>();
    static ArrayList<String> places=new ArrayList<>();
    static ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =(ListView) findViewById(R.id.listView);


        ArrayList<String> latitudes=new ArrayList<String>();
        ArrayList<String> longitudes=new ArrayList<String>();
        places.clear();
        latitudes.clear();
        longitudes.clear();
        locations.clear();

        SharedPreferences sharedPreferences=this.getSharedPreferences("com.example.harsh.memorableplaces", Context.MODE_PRIVATE);
        try {
            places=(ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("places",ObjectSerializer.serialize(new ArrayList<String>())));
            latitudes=(ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("latitudes",ObjectSerializer.serialize(new ArrayList<String>())));
            longitudes=(ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("longitudes",ObjectSerializer.serialize(new ArrayList<String>())));



        } catch (IOException e) {
            e.printStackTrace();
        }


        if(places.size() > 0 && latitudes.size()>0 && longitudes.size() > 0){

            if(places.size() == latitudes.size() && latitudes.size()== longitudes.size()){

            for(int i=0;i<latitudes.size();i++){

                locations.add(new LatLng(Double.parseDouble(latitudes.get(i)),Double.parseDouble( longitudes.get(i))));

            }


            }

        }else {

            places.add("Add a new place....");
            locations.add(new LatLng(0, 0));
        }
        arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,places);


        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
                intent.putExtra("placeNumber",i);
                startActivity(intent);



            }
        });
    }
}
