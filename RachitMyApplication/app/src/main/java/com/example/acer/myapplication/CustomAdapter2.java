package com.example.acer.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by acer on 7/10/2016.
 */
public class CustomAdapter2 extends ArrayAdapter<String> {
    String[] f;
    int[] a;
    String[] j;
    public CustomAdapter2(Context context, String[] food, int[] c, String[] v) {
        super(context,R.layout.custom_row,food);
        f=food;
        a=c;
        j=v;


    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(getContext());
        View customview=inflater.inflate(R.layout.custom_row,parent,false);

        TextView textView= (TextView) customview.findViewById(R.id.text);
        TextView textView1= (TextView) customview.findViewById(R.id.text2);
        ImageView imageView= (ImageView) customview.findViewById(R.id.image);
        textView.setText(f[position]);
        imageView.setImageResource(a[position]);
        textView1.setText(j[position]);







        return customview;

    }
}
