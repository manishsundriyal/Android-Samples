package com.example.harsh.secondapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;
public class MainActivity extends AppCompatActivity {

    int n=-1;
    public void buttonClicked(View view){
        if(n ==-1)
            n=getRandom();
        EditText number=(EditText) findViewById(R.id.numInput);
        String s=number.getText().toString();
        int num=Integer.parseInt(s);
        if(num==n){
            Toast.makeText(this, "You guessed it right!", Toast.LENGTH_SHORT).show();
            n=getRandom();
        }
        else if(num > n){
            Toast.makeText(this, "Your number is higher", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Your number is smaller", Toast.LENGTH_SHORT).show();
        }
    }

    public int getRandom(){
        Random rand=new Random();
        int n=rand.nextInt(20) +1;
        return n;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
