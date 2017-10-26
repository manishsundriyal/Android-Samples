package com.example.harsh.storage;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= (EditText) findViewById(R.id.editText1);
    }

    //common to all 5 methods, so instead of repeating
    //we made a function for it
    private void writeData(File myFile,String dataToWrite){
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream=new FileOutputStream(myFile);
            fileOutputStream.write(dataToWrite.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        message(dataToWrite + " saved to " +myFile.getAbsolutePath());


    }


    public void saveInternalCache(View view){

        String dataToWrite=editText.getText().toString();
        File folder=getCacheDir();
        File myFile=new File(folder,"mydata1.txt");
        writeData(myFile,dataToWrite);
    }

    public void saveExternalCache(View view){

        String dataToWrite=editText.getText().toString();
        File folder=getExternalCacheDir();
        File myFile=new File(folder,"mydata2.txt");
        writeData(myFile,dataToWrite);
    }

    public void saveExternalPrivate(View view){

        String dataToWrite=editText.getText().toString();
        //a folder called myApp will be created,
        //which is private to our app
        File folder=getExternalFilesDir("myApp");
        File myFile=new File(folder,"mydata3.txt");
        writeData(myFile,dataToWrite);
    }

    public void saveExternalPublic(View view){

        String dataToWrite=editText.getText().toString();
        File folder= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myFile=new File(folder,"mydata4.txt");
        writeData(myFile,dataToWrite);

    }

    public void goToNext(View view){
        Intent intent=new Intent(this,ActivityB.class);
        startActivity(intent);
    }

    public void message(String text){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }
}
