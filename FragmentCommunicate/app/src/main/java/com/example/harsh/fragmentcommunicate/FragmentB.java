package com.example.harsh.fragmentcommunicate;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentB extends Fragment {


    TextView textView;
    String currentData="";
    public FragmentB() {
        // Required empty public constructor
    }

 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_b, container, false);
        if(savedInstanceState==null){
            currentData="";
        }
        else{
            currentData=savedInstanceState.getString("currentData","");
            textView=view.findViewById(R.id.textView);
            textView.setText(currentData);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView=getActivity().findViewById(R.id.textView);
    }

    public void changeText(String data){
        currentData=data;
        textView.setText(currentData);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("currentData",currentData);
    }
}
