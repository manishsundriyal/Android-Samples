package com.example.harsh.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username;
    EditText password;
    EditText sample;
    Button loadData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username= (EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        sample= (EditText) findViewById(R.id.sample);
        loadData= (Button) findViewById(R.id.loadData);
        loadData.setOnClickListener(this);
    }
    public void saveData(View view){

        String user=username.getText().toString();
        String pass=password.getText().toString();

        FileOutputStream fos=null;
        try {
            fos=openFileOutput("data.txt",Context.MODE_PRIVATE);
            //to seperate our username and password
            user=user+ " ";
            byte[] bytes=user.getBytes();
            byte[] byte2=pass.getBytes();
            fos.write(bytes);
            fos.write(byte2);



        } catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
       /* SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString("username",username.getText().toString());
        editor.putString("password",password.getText().toString());
        editor.commit();*/
    }


    @Override
    public void onClick(View view) {
        StringBuffer buffer=new StringBuffer();
        try {
            FileInputStream fis=openFileInput("data.txt");
            //at end of file
            int read=-1;
            //StringBuffer allows us to directly modify the string
            while((read=fis.read())!=-1){
                buffer.append((char)read);

            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


     /*   SharedPreferences sharedPreferences=getSharedPreferences("MyData",Context.MODE_PRIVATE);
        String MyString=sharedPreferences.getString("username","");
        String MyString1=sharedPreferences.getString("password","");*/
        sample.setText(buffer);
    }
}
