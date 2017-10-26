package com.example.acer.myapplication;

/**
 * Created by acer on 7/9/2016.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by acer on 7/9/2016.
 */
public class CustomAdapter extends ArrayAdapter<String> {
    String[] f;
    int[] a;

    public CustomAdapter(Context context, String[] food,int[] c) {
        super(context,R.layout.custom_row,food);
        f=food;
        a=c;



    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(getContext());
        View customview=inflater.inflate(R.layout.custom_row2,parent,false);

        TextView textView= (TextView) customview.findViewById(R.id.textView);


        ImageView imageView= (ImageView) customview.findViewById(R.id.image);
        textView.setText(f[position]);
        imageView.setImageResource(a[position]);








        return customview;

    }
}
