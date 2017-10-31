package edu.illinois.zomatoapp.api.restaurant;

import com.google.gson.annotations.SerializedName;

public class RestaurantUserRating {
    @SerializedName("aggregate_rating")
    private String aggregateRating;
    @SerializedName("rating_text")
    private String ratingText;
    @SerializedName("rating_color")
    private String ratingColor;
    private String votes;

    public String getAggregateRating() {
        return aggregateRating;
    }

    public String getRatingText() {
        return ratingText;
    }

    public String getRatingColor() {
        return ratingColor;
    }

    public String getVotes() {
        return votes;
    }
}
