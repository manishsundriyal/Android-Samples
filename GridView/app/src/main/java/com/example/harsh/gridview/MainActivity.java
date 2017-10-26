package com.example.harsh.gridview;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=(GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new myAdapter(this));
        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)  {
        Intent intent=new Intent(this,DialogActivity.class);

        ViewHolder holder=(ViewHolder) view.getTag();
        Country temp= (Country) holder.myCountry.getTag();

        intent.putExtra("countryImage","");
        intent.putExtra("countryName","");
        startActivity(intent);
    }
}

class ViewHolder{
    ImageView myCountry;
    ViewHolder(View v){
        myCountry=(ImageView) v.findViewById(R.id.imageView);
    }
}


class Country{
    int imageId;
    String countryName;
    Country(int imageId, String countryName){
        this.imageId=imageId;
        this.countryName=countryName;
    }
}
class myAdapter extends BaseAdapter{
    ArrayList<Country> arrayList;
    Context context;

    myAdapter(Context c) {
        context = c;
        arrayList = new ArrayList<>();
        Resources res = (Resources) context.getResources();
        String[] tempNames = res.getStringArray(R.array.country_names);
        int[] images={R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5};
        for(int i=0;i<5;i++){
            Country country=new Country(images[i],tempNames[i]);
            arrayList.add(country);
        }
    }

    @Override
    public int getCount() {

        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row=view;
        ViewHolder holder=null;
        if(row==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_view, viewGroup, false);
            holder=new ViewHolder(row);
            row.setTag(holder);
        }
        else{
            holder=(ViewHolder) row.getTag();
        }
        Country temp=arrayList.get(i);
        holder.myCountry.setImageResource(temp.imageId);


        return row;
    }
}
