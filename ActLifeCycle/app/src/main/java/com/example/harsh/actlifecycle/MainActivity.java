package com.example.harsh.actlifecycle;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button button;
    ListView listView=new ListView(this);

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("i","onCreateCalled");
        button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do something
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("i","onStartCalled");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("i","onResumeCalled");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("i","onPauseCalled");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("i","onStopCalled");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("i","onDestroyCalled");

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){

        }
        Log.i("Testing","Config Changed");
    }



}
