package com.example.harsh.customadapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by harsh on 10/12/17.
 */

public class MyAdapter extends ArrayAdapter<String> {

    int imgs[];
    String title[];
    Context currentContext;
    MyAdapter(Context c, String titles[], int images[]) {

        super(c,R.layout.singlerow ,R.id.textView,titles);
        currentContext=c;
        title=titles;
        imgs=images;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row=convertView;
        MyViewHolder holder=null;
        if(row==null){
            LayoutInflater inflater=(LayoutInflater) currentContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.singlerow,parent,false);
            holder =new MyViewHolder(row);
            row.setTag(holder);
        }
        else{
            holder=(MyViewHolder) row.getTag();
        }
//        LayoutInflater inflater=(LayoutInflater) currentContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View row=inflater.inflate(R.layout.singlerow,parent,false);
        holder.imageView.setImageResource(imgs[position]);
        holder.titles.setText(title[position]);
        return row;
    }
}
