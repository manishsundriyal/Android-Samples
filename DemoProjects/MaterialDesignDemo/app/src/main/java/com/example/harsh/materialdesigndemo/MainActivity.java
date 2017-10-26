package com.example.harsh.materialdesigndemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

//DO NOT FORGET TO ADD DEPENDENCIES IN THE GRADLE FILE
//AND HARDWARE ACCELERATED TO TRUE IN MANIFEST

public class   MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab=(FloatingActionButton) findViewById(R.id.fab_add);
        listView=(ListView) findViewById(R.id.listView);

        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("Hello");
        arrayList.add("this");
        arrayList.add("is");
        arrayList.add("for");
        arrayList.add("testing");
        arrayList.add("purpose");
        arrayList.add("only");

        fab.setVisibility(View.INVISIBLE);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_activated_1,arrayList);
        listView.setAdapter(arrayAdapter);

    }

    public void fabOnClick(View view){
        Intent intent=new Intent(this,AddActivity.class);
        startActivity(intent);
    }

    private void AnimateShow(View view){
        ScaleAnimation scaleAnimation=new ScaleAnimation(0,1,0,1,0.5f,0.5f);
        //will ensure that the floating action button appears just before animating
        scaleAnimation.setFillBefore(true);
        //to ensure that the floating action button appears just after animation ends
        scaleAnimation.setFillAfter(true);
        //if we do not do this then setFillAfter won't happen
        scaleAnimation.setFillEnabled(true);
        //set duration time for animation to happen
        scaleAnimation.setDuration(300);
        //amount of time before the animation starts
        scaleAnimation.setStartOffset(500);
        //once our button expands, it will appear to snap back when we use overshoot interpolator
        scaleAnimation.setInterpolator(new OvershootInterpolator());
        //start animation for the view
        view.startAnimation(scaleAnimation);
    }

    //If you need to just continue the app which is
    // paused u will automatically directed to OnResume().
    @Override
    protected void onResume() {
        super.onResume();
        if(fab.getVisibility()==View.INVISIBLE){
            AnimateShow(fab);
        }
    }

    /*
    * - A new view in the AppCompat libraries is the RecyclerView.
     * The RecyclerView is superficially similar to the Listview but there are some circumstances where using it
     * is better and provides more power and flexibility. For example, there are more ways to display a RecyclerView
      * than a ListView. Not only does it scroll vertically like a ListView, but it can also scroll horizontally,
       * display as a grid, a staggered grid or you can even create your own completely custom layout.
        * The RecyclerView isn't part of the base AppCompat library and instead comes with the
         * Xamarin Android support v7 RecyclerView package.
    * */

    //To implement a recycler view, we need a View Holder. So we need to implement it.
}
