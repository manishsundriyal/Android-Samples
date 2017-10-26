package com.example.harsh.customadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    int images[]={android.R.drawable.ic_lock_idle_alarm,android.R.drawable.ic_delete, android.R.drawable.btn_default};
    String titles[]={"Hello World","Hello Kids","Hello men"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView) findViewById(R.id.listView);
        MyAdapter myAdapter=new MyAdapter(this,titles,images);
        listView.setAdapter(myAdapter);
    }
}

