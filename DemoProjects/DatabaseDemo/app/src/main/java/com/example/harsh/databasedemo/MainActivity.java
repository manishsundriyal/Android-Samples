package com.example.harsh.databasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try{
            SQLiteDatabase database = this.openOrCreateDatabase("users",MODE_PRIVATE,null);

//            database.execSQL("CREATE TABLE IF NOT EXISTS newUsers (name VARCHAR, age INT(3), id INTEGER PRIMARY KEY)");
//            database.execSQL("INSERT INTO newUsers (name, age) VALUES ('ABCD', 13)");
//            database.execSQL("INSERT INTO newUsers (name, age) VALUES ('Nothing', 123)");
//            database.execSQL("INSERT INTO users (name, age) VALUES ('Rob', 34)");

            database.execSQL("DELETE FROM newUsers WHERE id=6 OR id=8 OR id=10");

            Cursor c=database.rawQuery("SELECT * FROM newUsers",null);
            int ageIndex=c.getColumnIndex("age");
            int nameIndex=c.getColumnIndex("name");
            int id=c.getColumnIndex("id");

            c.moveToFirst();
            while(c!=null){

                Log.i("event",c.getString(nameIndex));
                Log.i("year", String.valueOf(c.getInt(ageIndex)));
                Log.i("id", String.valueOf(c.getInt(id)));
                c.moveToNext();
            }



        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
