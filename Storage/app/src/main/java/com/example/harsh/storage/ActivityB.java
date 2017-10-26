package com.example.harsh.storage;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ActivityB extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        editText= (EditText) findViewById(R.id.editText2);
    }


    public String  readData(File myFile){
        FileInputStream fileInputStream=null;
        StringBuffer myString = new StringBuffer();


        try {
           fileInputStream=new FileInputStream(myFile);
            int read=-1;
            while((read=fileInputStream.read())!=-1){
                myString.append((char) read);
            }
            return myString.toString();

        }

        catch (Exception e) {
            e.printStackTrace();
        }


        finally {
            if(fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
    public void loadInternalCache(View view){

        File folder=getCacheDir();
        File myFile=new File(folder,"mydata1.txt");
        String ans=readData(myFile);

        if(ans!=null){
            editText.setText(ans);
        }
        else{
            editText.setText("A problem occurred.");
        }
    }

    public void loadExternalCache(View view){
        File folder=getExternalCacheDir();
        File myFile=new File(folder,"mydata2.txt");
        String ans=readData(myFile);

        if(ans!=null){
            editText.setText(ans);
        }
        else{
            editText.setText("A problem occurred.");
        }

    }

    public void loadExternalPrivate(View view){
        File folder=getExternalFilesDir("myApp");
        File myFile=new File(folder,"mydata3.txt");
        String ans=readData(myFile);

        if(ans!=null){
            editText.setText(ans);
        }
        else{
            editText.setText("A problem occurred.");
        }

    }

    public void loadExternalPublic(View view){

        File folder=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myFile=new File(folder,"mydata4.txt");
        String ans=readData(myFile);

        if(ans!=null){
            editText.setText(ans);
        }
        else{
            editText.setText("A problem occurred.");
        }

    }

    public void previous(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void message(String text){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }
}
