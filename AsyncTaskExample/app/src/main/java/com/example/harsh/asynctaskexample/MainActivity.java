package com.example.harsh.asynctaskexample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mainList;
    private String[] texts={"Lorem", "ipsum","dolor" ,"sit", "amet" ,
            "consectetuer", "adipiscing", "elit", "Aenean", "commodo", "ligula", "eget" ,"dolor",
            "Aenean","massa",". Cum sociis","natoque", "penatibus ","et ","magnis ","dis ","parturient "
            ,"montes","nascetur", "ridiculus ","mus", "Donec quam felis", "ultricies ","nec", "pellentesque ",
            "eu, pretium", "quis","Lorem", "ipsum","dolor" ,"sit", "amet" ,
            "consectetuer", "adipiscing", "elit", "Aenean", "commodo", "ligula", "eget" ,"dolor",
            "Aenean","massa",". Cum sociis","natoque", "penatibus ","et ","magnis ","dis ","parturient "
            ,"montes","nascetur", "ridiculus ","mus", "Donec quam felis", "ultricies ","nec", "pellentesque ",
            "eu, pretium", "quis"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //our activity has an inbuilt progress bar
        //we can enable that, but before SET CONTENT VIEW

        //max for it is 10,000 by default
        requestWindowFeature(Window.FEATURE_PROGRESS);

        setContentView(R.layout.activity_main);
        mainList=findViewById(R.id.listView1);
        mainList.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>()));

        //no params given, because do in background
        //doesn't need params
        new MyTask().execute();

    }

    //inside MainActivity because I want access to listview and stuff
    class MyTask extends AsyncTask<Void,String,Void>{

        private ArrayAdapter<String> adapter;

        //to keep track of the elements added
        private int count=0;
        @Override
        protected void onPreExecute() {

            adapter= (ArrayAdapter<String>) mainList.getAdapter();

            setProgressBarIndeterminate(false);
            setProgressBarVisibility(true);
        }

        //only method to run on background thread
        //rest all of them run on UI thread
        @Override
        protected Void doInBackground(Void... voids) {

            for(String item:texts){
                //this will can onProgressUpdate
                publishProgress(item);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        //hum ek hi value pass kar rahe hain publishProgress mein
        //toh humne first element nikal liya seedha hi
        @Override
        protected void onProgressUpdate(String... values) {
            adapter.add(values[0]);
            count++;
            //10,000 max hota hai, so calculate progress this way
            setProgress((int)((count*10000) / texts.length));

            }


        @Override
        protected void onPostExecute(Void result) {
            setProgressBarVisibility(false);
            L.s(MainActivity.this,"All items added.");


        }
    }
}
