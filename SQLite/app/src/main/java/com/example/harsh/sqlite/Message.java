package com.example.harsh.sqlite;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by harsh on 10/20/17.
 */

public class Message {
    public static void message(Context context, String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();

    }
}
