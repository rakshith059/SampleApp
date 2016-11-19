package com.example.sample.sampleapp.models;

/**
 * Created by rakshith on 11/19/16.
 */
public class FoodListModel {

    private Integer imageUrl;
    private String foodTitle;
    private String foodPrice;
    private String foodQuantity;

    public FoodListModel(Integer imageUrl, String foodTitle, String foodPrice, String foodQuantity, String string) {
        this.setImageUrl(imageUrl);
        this.setFoodTitle(foodTitle);
        this.setFoodPrice(foodPrice);
        this.setFoodQuantity(foodQuantity);
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFoodTitle() {
        return foodTitle;
    }

    public void setFoodTitle(String foodTitle) {
        this.foodTitle = foodTitle;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(String foodQuantity) {
        this.foodQuantity = foodQuantity;
    }
}
