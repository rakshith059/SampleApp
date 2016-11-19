package com.example.sample.sampleapp.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sample.sampleapp.R;
import com.example.sample.sampleapp.listners.PriceQuantityListner;
import com.example.sample.sampleapp.models.FoodListModel;

import java.util.List;

/**
 * Created by rakshith on 11/19/16.
 */
public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.MyViewHolder> implements View.OnClickListener {
    ImageView ivImage;
    TextView tvTitle;
    TextView tvPrice;
    TextView tvQuantity;
    ImageView ivPlus;
    ImageView ivMinus;

    List<FoodListModel> foodListModels;
    PriceQuantityListner priceQuantityListner;

    public FoodListAdapter(List<FoodListModel> foodList) {
        foodListModels = foodList;
    }

    public FoodListAdapter() {

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab1_fragment, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final FoodListModel foodListModel = foodListModels.get(position);
        ((Activity) tvTitle.getContext()).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ivImage.setImageDrawable(ivImage.getContext().getResources().getDrawable(foodListModel.getImageUrl()));
                tvTitle.setText(foodListModel.getFoodTitle());
                tvQuantity.setText(foodListModel.getFoodQuantity());
                tvPrice.setText(tvPrice.getContext().getResources().getString(R.string.rs) + " " + foodListModel.getFoodPrice());
            }
        });

        ivPlus.setOnClickListener(this);
        ivMinus.setOnClickListener(this);
        ivMinus.setTag(position);
        ivPlus.setTag(position);
    }

    @Override
    public int getItemCount() {
        return foodListModels.size();
    }

    @Override
    public void onClick(final View view) {
        final int pos = (int) view.getTag();
        final String foodQuantity = tvQuantity.getText().toString();
        final int[] quantity = {Integer.parseInt(foodQuantity)};
        int foodActualPrice = Integer.parseInt(foodListModels.get(pos).getFoodPrice()) / quantity[0];
        switch (view.getId()) {
            case R.id.fragment_iv_minus:
                if (!TextUtils.isEmpty(foodQuantity)) {
                    if (quantity[0] > 1) {
                        quantity[0]--;
                        tvQuantity.setText(String.valueOf(quantity[0]));
                        int foodPrice = getFoodPrice(quantity[0], foodActualPrice);
                        tvPrice.setText(tvPrice.getContext().getResources().getString(R.string.rs) + " " + foodPrice);
                        priceQuantityListner.totalPriceCallback(pos, quantity[0], foodPrice);
                    }
                }
                break;
            case R.id.fragment_iv_plus:
                if (!TextUtils.isEmpty(foodQuantity)) {
                    quantity[0]++;
                    tvQuantity.setText(String.valueOf(quantity[0]));
                    int foodPrice = getFoodPrice(quantity[0], foodActualPrice);
                    tvPrice.setText(tvPrice.getContext().getResources().getString(R.string.rs) + " " + foodPrice);
                    priceQuantityListner.totalPriceCallback(pos, quantity[0], foodPrice);
                }
                break;
            default:
                break;
        }

    }

    private int getFoodPrice(int quantity, int foodActualPrice) {
        int foodTotalPrice = quantity * foodActualPrice;
        return foodTotalPrice;
    }

    public void setPriceListner(PriceQuantityListner priceListner) {
        priceQuantityListner = priceListner;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
            ivImage = (ImageView) itemView.findViewById(R.id.fragment_iv_image);
            tvTitle = (TextView) itemView.findViewById(R.id.fragment_tv_title);
            tvPrice = (TextView) itemView.findViewById(R.id.fragment_tv_price);
            tvQuantity = (TextView) itemView.findViewById(R.id.fragment_tv_quantity);
            ivPlus = (ImageView) itemView.findViewById(R.id.fragment_iv_plus);
            ivMinus = (ImageView) itemView.findViewById(R.id.fragment_iv_minus);
        }
    }
}

