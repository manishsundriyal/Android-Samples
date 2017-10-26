package com.example.acer.myapplication.Hum;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.myapplication.Com.comm;
import com.example.acer.myapplication.R;

/**
 * Created by acer on 7/15/2016.
 */
public class Humanity_details extends AppCompatActivity {
    public static final String EXTRA_NO = "yo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        int no = (int) getIntent().getExtras().get(EXTRA_NO);
        hummm drink = hummm.drinks[no];
//Populate the drink image
        ImageView photo = (ImageView) findViewById(R.id.imageView4);
        photo.setImageResource(drink.getImageResourceId());


//Populate the drink name


//Populate the drink description
        TextView description = (TextView) findViewById(R.id.description);
        description.setText(drink.getDescription());
        TextView salary = (TextView) findViewById(R.id.salarytext);
        salary.setText(drink.getSalary());
        TextView mand = (TextView) findViewById(R.id.mand);
        mand.setText(drink.getMand());


    }
}

