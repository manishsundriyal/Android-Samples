package com.example.harsh.mydrawerlayout;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    DrawerLayout drawerLayout;
    ListView listView;
    String[] planets;
    ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout= (DrawerLayout) findViewById(R.id.drawerLayout);
        listView= (ListView) findViewById(R.id.drawerList);
        planets=getResources().getStringArray(R.array.planets);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,planets));
        listView.setOnItemClickListener(this);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.drawer_open,R.string.drawer_closed){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.setDrawerListener(toggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        toggle.syncState();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            selectedOption(i);
        setTitle(planets[i]);
    }

    public void selectedOption(int i) {
        listView.setItemChecked(i,true);
    }
    public void setTitle(String data){
        getSupportActionBar().setTitle(data);
    }

}
