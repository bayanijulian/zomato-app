package edu.illinois.zomatoapp.api.restaurant;

import com.google.gson.annotations.SerializedName;

public class RestaurantCollection {
    @SerializedName("results_found")
    private int resultsFound;
    @SerializedName("results_start")
    private int resultsStart;
    @SerializedName("results_shown")
    private int resultsShown;
    @SerializedName("restaurants")
    private RestaurantHolder[] restaurantHolders;

    public int getResultsFound() {
        return resultsFound;
    }

    public int getResultsStart() {
        return resultsStart;
    }

    public int getResultsShown() {
        return resultsShown;
    }

    public RestaurantHolder[] getRestaurantHolders() {
        return restaurantHolders;
    }

    public Restaurant[] getRestaurants() {
        Restaurant[] restaurants = new Restaurant[restaurantHolders.length];

        for (int i = 0; i < restaurantHolders.length; i++) {
            restaurants[i] = restaurantHolders[i].getRestaurant();
        }

        return restaurants;
    }
}
