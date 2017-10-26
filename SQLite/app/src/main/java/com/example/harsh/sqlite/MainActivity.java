package com.example.harsh.sqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    MyAdapterDatabase myHelper;
    EditText pass;
    EditText editText;
    EditText nameToGet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //onCreate not called
        //only the constructor
        myHelper=new MyAdapterDatabase(this);
        pass= (EditText) findViewById(R.id.editText2);
        editText= (EditText) findViewById(R.id.editText);
        nameToGet= (EditText) findViewById(R.id.editText3);

        //now the oncreate is called
        //SQLite is effecient because it avoids the database creation
        //overhead by creating the databse only when someone tries
        //accessing it for the first time.
}

    public void addToDB(View view){
        String text=editText.getText().toString();
        String password=pass.getText().toString();

        long id=myHelper.insertData(text,password);
        if(id<0){
            Message.message(this,"Unsuccessful");
        }
        else{
            Message.message(this,"Successful");
        }


    }

    public void viewDetails(View view){

        String data=myHelper.getAllData();
        Message.message(this,data);
    }

    public void getNameResults(View view){
        String enteredText=nameToGet.getText().toString();
        String name=enteredText.substring(0,enteredText.indexOf(" "));
        String password=enteredText.substring(enteredText.indexOf(" ")+1);

        String answer=myHelper.getData(name,password);
        Message.message(this,answer);
    }

    public void update(View view){
        myHelper.updateName("ABCD","QWERTY");

    }

    public void delete(View view){

        int c=myHelper.deleteRow("QWERTY");
        Message.message(this,String.valueOf(c));
    }
}
