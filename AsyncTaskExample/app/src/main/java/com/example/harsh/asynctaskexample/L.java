package com.example.harsh.asynctaskexample;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by harsh on 10/23/17.
 */

public class L {

    public static void m(String message){
        Log.d("Testing",message);
    }

    public static void s(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }
}
