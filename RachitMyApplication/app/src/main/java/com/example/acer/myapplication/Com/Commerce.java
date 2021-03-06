package com.example.acer.myapplication.Com;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.acer.myapplication.R;
import com.example.acer.myapplication.Sci.Aesthetic;
import com.example.acer.myapplication.Sci.Aesthetic_details;
import com.example.acer.myapplication.Sci.Career_list;
import com.example.acer.myapplication.Com.Commerce_details;

public class Commerce extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commerce);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener(){
                    public void onItemClick(AdapterView<?> listView,
                                            View v,
                                            int position,
                                            long id) {
                        Intent intent = new Intent(Commerce.this,
                                Commerce_details.class);
                        intent.putExtra(Commerce_details.EXTRA_NO,(int)id);
                        startActivity(intent);




                    }
                };
//Add the listener to the list view
        ListView listView = (ListView) findViewById(R.id.listcomeerce);
        listView.setOnItemClickListener(itemClickListener);
    }
    }


