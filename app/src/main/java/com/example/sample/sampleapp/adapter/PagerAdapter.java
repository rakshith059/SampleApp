package com.example.sample.sampleapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.sample.sampleapp.fragments.Tab1Fragment;
import com.example.sample.sampleapp.fragments.Tab2Fragment;
import com.example.sample.sampleapp.fragments.Tab3Fragment;
import com.example.sample.sampleapp.fragments.Tab4Fragment;

/**
 * Created by Belal on 2/3/2016.
 */
//Extending FragmentStatePagerAdapter
public class PagerAdapter extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public PagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount = tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                Tab1Fragment tab1Fragment = new Tab1Fragment();
                return tab1Fragment;
            case 1:
                Tab2Fragment tab2Fragment = new Tab2Fragment();
                return tab2Fragment;
//            case 2:
//                Tab3Fragment tab3Fragment = new Tab3Fragment();
//                return tab3Fragment;
             case 2:
                Tab1Fragment tab3Fragment = new Tab1Fragment();
                return tab3Fragment;
            case 3:
                Tab4Fragment tab4Fragment = new Tab4Fragment();
                return tab4Fragment;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}