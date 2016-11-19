package com.example.sample.sampleapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sample.sampleapp.R;
import com.example.sample.sampleapp.adapter.FoodListAdapter;
import com.example.sample.sampleapp.listners.PriceQuantityListner;
import com.example.sample.sampleapp.models.FoodListModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Belal on 2/3/2016.
 */

//Our class extending fragment
public class Tab1Fragment extends Fragment {

    private RecyclerView rvList;
    List<FoodListModel> foodList = new ArrayList<>();
    FoodListAdapter foodListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        View view = inflater.inflate(R.layout.common_recyclerview, container, false);
        rvList = (RecyclerView) view.findViewById(R.id.common_recycler_rv_list);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        foodListAdapter = new FoodListAdapter(foodList);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(rvList.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvList.setLayoutManager(layoutManager);
        rvList.setItemAnimator(new DefaultItemAnimator());
        rvList.setAdapter(foodListAdapter);

        getFoodList();
        foodListAdapter.setPriceListner(new PriceQuantityListner() {
            @Override
            public void totalPriceCallback(int pos, int quantity, int totalPrice) {
                foodListAdapter.notifyItemChanged(pos);
            }
        });
    }

    private void getFoodList() {
        FoodListModel foodListModel = new FoodListModel(R.mipmap.burger, "Burger", "100", "1", getResources().getString(R.string.veg));
        foodList.add(foodListModel);
        foodListModel = new FoodListModel(R.mipmap.chaartimes, "Chaat Times", "200", "1", getResources().getString(R.string.veg));
        foodList.add(foodListModel);
        foodListModel = new FoodListModel(R.mipmap.polarbear, "Polar bear", "300", "1", getResources().getString(R.string.non_veg));
        foodList.add(foodListModel);
        foodListModel = new FoodListModel(R.mipmap.samosa, "Samosa", "400", "1", getResources().getString(R.string.veg));
        foodList.add(foodListModel);
        foodListModel = new FoodListModel(R.mipmap.sandwitch, "Sandwitch", "500", "1", getResources().getString(R.string.veg));
        foodList.add(foodListModel);
        foodListModel = new FoodListModel(R.mipmap.subway, "Subway", "600", "1", getResources().getString(R.string.veg));
        foodList.add(foodListModel);
        foodListModel = new FoodListModel(R.mipmap.pizza, "Pizza", "800", "1", getResources().getString(R.string.non_veg));
        foodList.add(foodListModel);
        foodListModel = new FoodListModel(R.mipmap.maiyas, "Maiyas", "900", "1", getResources().getString(R.string.non_veg));
        foodList.add(foodListModel);

        foodListAdapter.notifyDataSetChanged();
    }
}