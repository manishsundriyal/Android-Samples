package com.example.harsh.flexibleui;

import android.app.Activity;
import android.content.Intent;
import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity implements FragmentA.Communicator{

    FragmentA fragmentA;
    FragmentB fragmentB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentA= (FragmentA) getFragmentManager().findFragmentById(R.id.fragA);
        fragmentA.setCom(this);
    }

    @Override
    public void respond(int i) {

        fragmentB= (FragmentB) getFragmentManager().findFragmentById(R.id.fragB);

        if(fragmentB!=null && fragmentB.isVisible()){
            //inside landscape
            fragmentB.changeData(i);
        }
        else{
            Intent intent=new Intent(this,AnotherActivity.class);
            intent.putExtra("index",i);
        }



    }
}
