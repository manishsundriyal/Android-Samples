package com.example.harsh.flexibleui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AnotherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        Intent intent=getIntent();
        int i=intent.getIntExtra("index",0);

        FragmentB fragmentB= (FragmentB) getFragmentManager().findFragmentById(R.id.fragB);
        if(fragmentB!=null){
            fragmentB.changeData(i);
        }

    }
}

