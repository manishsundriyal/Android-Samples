package com.example.harsh.flexibleui;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment {

    Communicator com;

    ListView listView;
    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_a, container, false);
        listView=view.findViewById(R.id.listView);
        ArrayAdapter arrayAdapter=ArrayAdapter.createFromResource(getActivity(),R.array.chapters,android.R.layout.simple_list_item_1);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                com.respond(i);
            }
        });
        return view;
    }

    public void setCom(Communicator com) {
        this.com = com;
    }

    public interface Communicator{
        public void respond(int i);
    }
}
