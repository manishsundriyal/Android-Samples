package com.example.harsh.baseadapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.listView);
        listView.setAdapter(new MyAdapter(this));
    }
}

class SingleRow{
    String title;
    String description;
    int image;
    SingleRow(String t, String des, int ima){
        this.image=ima;
        this.title=t;
        this.description=des;
    }
}

class MyAdapter extends BaseAdapter{

    ArrayList<SingleRow> arrayList;
    Context currentContext;
    //context mujhe resources access karne ke liye chahiye
    MyAdapter(Context c){
        currentContext=c;
        arrayList=new ArrayList<SingleRow>();
        Resources resources=c.getResources();
        String[] titles= resources.getStringArray(R.array.titles);
        String[] descriptions= resources.getStringArray(R.array.descriptions);
        int[] images= {android.R.drawable.alert_dark_frame,android.R.drawable.btn_default, android.R.drawable.arrow_up_float, android.R.drawable.ic_delete};
        for(int i=0;i<4;i++){

            //We could also do,
//            SingleRow s=new SingleRow(titles[i],descriptions[i],images[i]);
//            arrayList.add(s);

            arrayList.add(new SingleRow(titles[i],descriptions[i],images[i]));

        }
    }

//    String[] titles;
//    String[] descriptions;
//    int[] images;

    @Override
    public int getCount() {
        return arrayList.size();
//        return 0;
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
//        return null;
    }

    //Databases mein, index i ek
    //item id ko point karega jissey hum uss object
    //ko access kar payenge
    //But humare case mein i hi id hai
    //because databases mahi hain
    @Override
    public long getItemId(int i) {
        return i;
//        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) currentContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single_row,viewGroup,false);
        TextView title= (TextView) row.findViewById(R.id.textView);
        TextView description =(TextView) row.findViewById(R.id.textView2);
        ImageView image=(ImageView)row.findViewById(R.id.imageView);

        SingleRow temp=arrayList.get(i);
        title.setText(temp.title);
        description.setText(temp.description);
        image.setImageResource(temp.image);







        return row;
    }
}
