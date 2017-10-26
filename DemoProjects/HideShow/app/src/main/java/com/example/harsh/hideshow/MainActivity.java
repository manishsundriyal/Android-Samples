package com.example.harsh.hideshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean isShowing=true;
    public void showButton(View view){
        if(isShowing==false) {
            TextView tv = (TextView) findViewById(R.id.textView);
            tv.setVisibility(View.VISIBLE);
            isShowing = true;
        }
    }
    public void hideButton(View view){
        if(isShowing==true) {
            TextView tv = (TextView) findViewById(R.id.textView);
            tv.setVisibility(View.INVISIBLE);
            isShowing = false;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
