package edu.illinois.zomatoapp.api.location;

import com.google.gson.annotations.SerializedName;

public class LocationCollection {
    @SerializedName("location_suggestions")
    private Location[] locations;
    private String status;
    @SerializedName("has_more")
    private int hasMore;
    @SerializedName("has_total")
    private int hasTotal;

    public Location[] getLocations() {
        return locations;
    }

    public String getStatus() {
        return status;
    }

    public int hasMore() {
        return hasMore;
    }

    public int hasTotal() {
        return hasTotal;
    }
}
