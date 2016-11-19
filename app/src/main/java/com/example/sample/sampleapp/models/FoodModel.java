package com.example.sample.sampleapp.models;

/**
 * Created by rakshith on 11/8/16.
 */
public class FoodModel {
    private Integer imageUrl;
    private String foodTitle;
    private String foodSubTitle;
    private String foodCost;
    private String foodRating;
    private String foodTime;

    public FoodModel(Integer imageUrl, String foodTitle, String foodSubTitle, String foodCost, String foodRating, String foodTime) {
        this.imageUrl = imageUrl;
        this.foodTitle = foodTitle;
        this.foodSubTitle = foodSubTitle;
        this.foodCost = foodCost;
        this.foodRating = foodRating;
        this.foodTime = foodTime;
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

    public String getFoodSubTitle() {
        return foodSubTitle;
    }

    public void setFoodSubTitle(String foodSubTitle) {
        this.foodSubTitle = foodSubTitle;
    }

    public String getFoodCost() {
        return foodCost;
    }

    public void setFoodCost(String foodCost) {
        this.foodCost = foodCost;
    }

    public String getFoodRating() {
        return foodRating;
    }

    public void setFoodRating(String foodRating) {
        this.foodRating = foodRating;
    }

    public String getFoodTime() {
        return foodTime;
    }

    public void setFoodTime(String foodTime) {
        this.foodTime = foodTime;
    }
}
