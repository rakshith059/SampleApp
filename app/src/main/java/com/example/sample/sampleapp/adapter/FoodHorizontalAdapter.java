package com.example.sample.sampleapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sample.sampleapp.R;
import com.example.sample.sampleapp.models.FoodModel;

import java.util.List;

/**
 * Created by rakshith on 11/8/16.
 */
public class FoodHorizontalAdapter extends RecyclerView.Adapter<FoodHorizontalAdapter.MyViewHolder> {

    private List<FoodModel> horizontalList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvSubTitle;
        TextView tvCost;
        TextView tvTime;

        public MyViewHolder(View view) {
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.horizontal_item_view_tv_title);
            tvSubTitle = (TextView) view.findViewById(R.id.horizontal_item_view_tv_subtitle);
            tvCost = (TextView) view.findViewById(R.id.horizontal_item_view_tv_cost);
            tvTime = (TextView) view.findViewById(R.id.horizontal_item_view_tv_time);
        }
    }

    public FoodHorizontalAdapter(List<FoodModel> horizontalList) {
        this.horizontalList = horizontalList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.horizontal_item_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        FoodModel foodModel = horizontalList.get(position);
        holder.tvTitle.setText(foodModel.getFoodTitle());
        holder.tvSubTitle.setText(foodModel.getFoodSubTitle());
        holder.tvCost.setText(holder.tvCost.getContext().getResources().getString(R.string.rs) + " " + foodModel.getFoodCost());
        holder.tvTime.setText(foodModel.getFoodTime());
    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }
}
