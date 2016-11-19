package com.example.sample.sampleapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sample.sampleapp.R;
import com.example.sample.sampleapp.adapter.FoodAdapter;
import com.example.sample.sampleapp.adapter.FoodHorizontalAdapter;
import com.example.sample.sampleapp.models.FoodModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvHorizontalList;
    RecyclerView rvVerticalList;
    FoodAdapter foodAdapter;
    FoodHorizontalAdapter foodHorizontalAdapter;
    List<FoodModel> foodVerticalList = new ArrayList<>();
    List<FoodModel> foodHorizontalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvVerticalList = (RecyclerView) findViewById(R.id.activity_main_rv_vertical_list);
        rvHorizontalList = (RecyclerView) findViewById(R.id.activity_main_rv_horizontal_list);
        foodAdapter = new FoodAdapter(foodVerticalList);
        foodHorizontalAdapter = new FoodHorizontalAdapter(foodVerticalList);
//        foodHorizontalAdapter = new FoodHorizontalAdapter(foodHorizontalList);

        final LinearLayoutManager layoutHorizontalManager = new LinearLayoutManager(this);
        layoutHorizontalManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvHorizontalList.setLayoutManager(layoutHorizontalManager);
        rvHorizontalList.setItemAnimator(new DefaultItemAnimator());
        rvHorizontalList.setAdapter(foodHorizontalAdapter);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvVerticalList.setLayoutManager(layoutManager);
        rvVerticalList.setItemAnimator(new DefaultItemAnimator());
        rvVerticalList.setAdapter(foodAdapter);

//        rvHorizontalList.setAdapter(foodAdapter);

        getFoodList();
//        getFoodHorizontalList();
    }

    private void getFoodList() {
        FoodModel foodModel = new FoodModel(R.mipmap.burger,"Burger", "American Food", "100", "4", "10 min");
        foodVerticalList.add(foodModel);
        foodModel = new FoodModel(R.mipmap.chaartimes,"Chaat Times", "Bangalore", "200", "4.2", "20 min");
        foodVerticalList.add(foodModel);
        foodModel = new FoodModel(R.mipmap.polarbear,"Polar bear", "IceCream", "300", "4.4", "30 min");
        foodVerticalList.add(foodModel);
        foodModel = new FoodModel(R.mipmap.samosa,"Samosa", "Rajasthani,Gujarath", "400", "3.4", "40 min");
        foodVerticalList.add(foodModel);
        foodModel = new FoodModel(R.mipmap.sandwitch,"Sandwitch", "American Food", "500", "2.9", "50 min");
        foodVerticalList.add(foodModel);
        foodModel = new FoodModel(R.mipmap.subway,"Subway", "Mexican Food", "600", "4.2", "25 min");
        foodVerticalList.add(foodModel);
       /* foodModel = new FoodModel(R.mipmap.taccobell,"Tacco Bell", "Mexican Food, "7.0", "4.4", "3 min");
        foodVerticalList.add(foodModel);*/
        foodModel = new FoodModel(R.mipmap.pizza,"Pizza", "American Food", "800", "3.4", "44 min");
        foodVerticalList.add(foodModel);
        foodModel = new FoodModel(R.mipmap.maiyas,"Maiyas", "Bangalore", "900", "2.9", "51 min");
        foodVerticalList.add(foodModel);

        foodAdapter.notifyDataSetChanged();
    }
}
