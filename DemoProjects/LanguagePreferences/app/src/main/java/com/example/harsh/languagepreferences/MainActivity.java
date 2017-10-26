package com.example.harsh.languagepreferences;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    SharedPreferences sharedPreferences;
    TextView textView;
    public void setLanguage(String language){
        sharedPreferences.edit().putString("Language",language).apply();
        textView.setText(language);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);
        if(item.getItemId()==R.id.english){
                setLanguage("English");

        }else if(item.getItemId()==R.id.spanish){

                setLanguage("Spanish");
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sharedPreferences=this.getSharedPreferences("com.example.harsh.languagepreferences", Context.MODE_PRIVATE);
        textView=(TextView) findViewById(R.id.textView);
        String language=sharedPreferences.getString("Language","");
        if(language==""){

        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setTitle("Choose Language")
                .setMessage("Which language would you like ?")
                .setPositiveButton("English", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        setLanguage("English");
                    }
                })
                .setNegativeButton("Spanish", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        setLanguage("Spanish");
                    }
                }).show();
        }
        else{

            textView.setText(language);
        }
    }
}
