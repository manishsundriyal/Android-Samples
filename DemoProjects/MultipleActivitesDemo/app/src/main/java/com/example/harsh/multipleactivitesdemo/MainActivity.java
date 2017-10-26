package com.example.harsh.multipleactivitesdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)  findViewById(R.id.listView);

        final ArrayList<String> arrayList=new ArrayList<String >();
        arrayList.add("rob");
        arrayList.add("kirsten");
        arrayList.add("tommy");
        arrayList.add("ralphie");

        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             Intent intent=new Intent(getApplicationContext(),SecondActivity.class);
                intent.putExtra("name",arrayList.get(i));
                startActivity(intent);
            }
        });

    }
}
