package com.example.harsh.customadapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by harsh on 10/12/17.
 */

public class MyViewHolder {
    ImageView imageView;
    TextView titles;

    MyViewHolder(View v){
        imageView=(ImageView)v.findViewById(R.id.imageView);
        titles=(TextView) v.findViewById(R.id.textView);
    }
}
