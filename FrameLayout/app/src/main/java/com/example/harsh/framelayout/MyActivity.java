package com.example.harsh.framelayout;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by harsh on 10/11/17.
 */

public class MyActivity extends ListActivity {
    String[] days={"Sunday", "Monday","Tuesday"};
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_xml);
        listView=getListView();
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,days);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        TextView textView=(TextView) v;
        Toast.makeText(this,textView.getText(),Toast.LENGTH_SHORT).show();
        super.onListItemClick(l, v, position, id);

    }
}
