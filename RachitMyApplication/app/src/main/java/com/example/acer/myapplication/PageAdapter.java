package com.example.acer.myapplication;

import android.support.v4.app.FragmentStatePagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by acer on 7/9/2016.
 */
public class PageAdapter extends FragmentStatePagerAdapter {
    int tabs;
    public PageAdapter(FragmentManager fm,int tabs)
    { super(fm);
        this.tabs=tabs;

    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Tab1 tab1 = new Tab1();
                return tab1;
            case 1:
                Tab2 tab2 = new Tab2();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabs;
    }
}
