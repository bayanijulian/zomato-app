package edu.illinois.zomatoapp.api.cuisine;

import com.google.gson.annotations.SerializedName;

public class Cuisine {
    @SerializedName("cuisine_id")
    private int id;
    @SerializedName("cuisine_name")
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
