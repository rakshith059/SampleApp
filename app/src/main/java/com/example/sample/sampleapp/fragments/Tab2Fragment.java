package com.example.sample.sampleapp.fragments;

/**
 * Created by supre on 11/17/2016.
 */
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import com.example.sample.sampleapp.R;

/**
 * Created by Belal on 2/3/2016.
 */

//Our class extending fragment
public class Tab2Fragment extends Fragment {

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab2_fragment in you classes
        return inflater.inflate(R.layout.tab2_fragment, container, false);
    }
}