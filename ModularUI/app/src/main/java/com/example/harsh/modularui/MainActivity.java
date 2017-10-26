package com.example.harsh.modularui;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void respond(int i) {
            FragmentB fragmentB= (FragmentB) getFragmentManager().findFragmentById(R.id.fragB);
        fragmentB.changeData(i);

    }
}
