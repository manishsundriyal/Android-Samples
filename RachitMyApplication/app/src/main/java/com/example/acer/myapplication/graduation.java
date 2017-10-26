package com.example.acer.myapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class graduation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graduation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView listView= (ListView) findViewById(R.id.list);
        ArrayAdapter<Grad> adapter=new ArrayAdapter<Grad>(this,android.R.layout.simple_list_item_1,Grad.grad);
        listView.setAdapter(adapter);
        AdapterView.OnItemClickListener itemClickListener=new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent i=new Intent(graduation.this,grad_art.class);
                    startActivity(i);

                }
                if(position==1)
                {
                    Intent i=new Intent(graduation.this,grad_maths.class);
                    startActivity(i);


                }
                if(position==3)
                {
                    Intent i=new Intent(graduation.this,grad_com.class);
                    startActivity(i);

                }
                if(position==2)
                {
                    Intent i=new Intent(graduation.this,grad_bio.class);
                    startActivity(i);

                }

            }
        };
        listView.setOnItemClickListener(itemClickListener);


    }

}
