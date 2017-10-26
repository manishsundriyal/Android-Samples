package com.example.harsh.fragmentcommunicate;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity implements Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onRespond(String data) {
        FragmentB fragmentB= (FragmentB) getFragmentManager().findFragmentById(R.id.fragB);
        fragmentB.changeText(data);

    }
}
