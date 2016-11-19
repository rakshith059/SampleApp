package com.example.sample.sampleapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sample.sampleapp.R;

/**
 * Created by rakshith on 11/19/16.
 */
public class Tab4Fragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab4_fragment , null);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
