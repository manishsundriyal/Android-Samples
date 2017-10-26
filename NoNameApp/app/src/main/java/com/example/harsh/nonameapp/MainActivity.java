package com.example.harsh.nonameapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==1){
            if(grantResults.length > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                CursorCall();
            }
        }
    }

    public void CursorCall() {
        List<String> stringList=new ArrayList<>();
        Uri mSmsinboxQueryUri = Uri.parse("content://sms/inbox");
        Cursor cursor = getContentResolver().query(mSmsinboxQueryUri,new String[] { "_id", "thread_id", "address", "person", "date","body", "type" }, null, null, null);
        String[] columns = new String[] { "address", "person", "date", "body","type" };
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()){
                String address = cursor.getString(cursor.getColumnIndex(columns[0]));
                String name = cursor.getString(cursor.getColumnIndex(columns[1]));
                String date = cursor.getString(cursor.getColumnIndex(columns[2]));
                String msg = cursor.getString(cursor.getColumnIndex(columns[3]));
                String type = cursor.getString(cursor.getColumnIndex(columns[4]));
                stringList.add(msg);
            }
        }

        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,stringList);
        listView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView) findViewById(R.id.listView);

        if(Build.VERSION.SDK_INT < 23){
            CursorCall();
        }else{
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_SMS},1);
            }else{
                CursorCall();
            }
        }
    }
}