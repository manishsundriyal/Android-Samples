package com.example.acer.myapplication;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by acer on 7/9/2016.
 */
public class Tab1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_fragment_1, container, false);
         String[] food={"Class 12","Graduation"};
        int[] image={R.drawable.ten,R.drawable.grad};



        ListView listView= (ListView) v.findViewById(R.id.listview);
        ListAdapter listAdapter=new CustomAdapter(getActivity(),food,image);

        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if(position==0) {
                            Intent intent = new Intent(getActivity(), choose.class);
                            startActivity(intent);
                        }
                        if(position==1) {
                            Intent intent = new Intent(getActivity(), graduation.class);
                            startActivity(intent);
                        }


                    }
                }
        );




        return v;



}

}
