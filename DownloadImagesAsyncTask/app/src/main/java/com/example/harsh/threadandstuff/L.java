package com.example.harsh.threadandstuff;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by harsh on 10/21/17.
 */

public class L {
    public static void m(String message){
        Log.d("Testing",message);
    }

    public static void s(Context context,String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
