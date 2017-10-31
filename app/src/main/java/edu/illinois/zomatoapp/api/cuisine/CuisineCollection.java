package edu.illinois.zomatoapp.api.cuisine;

import com.google.gson.annotations.SerializedName;

public class CuisineCollection {

    @SerializedName("cuisines")
    private CuisineHolder[] cuisineHolders;

    public CuisineHolder[] getCuisineHolders() {
        return cuisineHolders;
    }
}
