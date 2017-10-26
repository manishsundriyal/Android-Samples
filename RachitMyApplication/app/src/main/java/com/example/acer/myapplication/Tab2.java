package com.example.acer.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by acer on 7/9/2016.
 */
public class Tab2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_fragment_2, container, false);
        String[] food={"Jobs","FAQ"};
        int[] image={R.drawable.jobs,R.drawable.faq};
        String[] x={"Detailed info to search for good job","Frequently asked questions"};


        ListView listView= (ListView) v.findViewById(R.id.listview2);
        ListAdapter listAdapter=new CustomAdapter2(getActivity(),food,image,x);

        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
        );
        return v;
    }
}
