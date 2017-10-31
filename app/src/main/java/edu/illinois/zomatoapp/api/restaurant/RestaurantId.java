package edu.illinois.zomatoapp.api.restaurant;

import com.google.gson.annotations.SerializedName;

public class RestaurantId {
    @SerializedName("res_id")
    private int restaurantId;

    public int getRestaurantId() {
        return restaurantId;
    }
}
