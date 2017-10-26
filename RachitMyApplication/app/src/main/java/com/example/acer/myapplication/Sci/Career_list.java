package com.example.acer.myapplication.Sci;

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

public class Career_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Create an OnItemClickListener
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener(){
                    public void onItemClick(AdapterView<?> listView,
                                            View v,
                                            int position,
                                            long id) {

                            Intent intent = new Intent(Career_list.this,
                                    Detail.class);
                        intent.putExtra(Detail.EXTRA_NO,(int)id);
                            startActivity(intent);

                    }
                };
//Add the listener to the list view
        ListView listView = (ListView) findViewById(R.id.listViewee);
        listView.setOnItemClickListener(itemClickListener);



    }

}
