package com.example.sample.sampleapp.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sample.sampleapp.R;
import com.example.sample.sampleapp.models.FoodModel;
import com.example.sample.sampleapp.activities.ViewPagerActivity;

import java.util.List;

/**
 * Created by rakshith on 11/8/16.
 */
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> implements View.OnClickListener{
    ImageView ivImage;
    TextView tvTitle;
    TextView tvSubTitle;
    TextView tvCost;
    TextView tvRating;
    TextView tvTime;

    List<FoodModel> foodModels;

    public FoodAdapter(List<FoodModel> foodList) {
        foodModels = foodList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_adapter, parent, false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FoodModel foodModel = foodModels.get(position);

        ivImage.setImageDrawable(ivImage.getContext().getResources().getDrawable(foodModel.getImageUrl()));
        tvTitle.setText(foodModel.getFoodTitle());
        tvSubTitle.setText(foodModel.getFoodSubTitle());
        tvCost.setText(tvCost.getContext().getResources().getString(R.string.rs) + " " + foodModel.getFoodCost());
        tvRating.setText(foodModel.getFoodRating());
        tvTime.setText(foodModel.getFoodTime());
    }

    @Override
    public int getItemCount() {
        return foodModels.size();
    }
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(view.getContext(), ViewPagerActivity.class);
       view.getContext().startActivity(intent);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
            ivImage = (ImageView) itemView.findViewById(R.id.food_adapter_iv_Image);
            tvTitle = (TextView) itemView.findViewById(R.id.food_adapter_tv_title);
            tvSubTitle = (TextView) itemView.findViewById(R.id.food_adapter_tv_subtitle);
            tvCost = (TextView) itemView.findViewById(R.id.food_adapter_tv_cost);
            tvRating = (TextView) itemView.findViewById(R.id.food_adapter_tv_rating);
            tvTime = (TextView) itemView.findViewById(R.id.food_adapter_tv_time);
        }
    }
}
