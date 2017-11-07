package edu.illinois.zomatoapp.api.restaurant;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class RestaurantUserRating implements Parcelable {
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

    /* Below code was automatically generated from the parcelable plugin */

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.aggregateRating);
        dest.writeString(this.ratingText);
        dest.writeString(this.ratingColor);
        dest.writeString(this.votes);
    }

    public RestaurantUserRating() {
    }

    protected RestaurantUserRating(Parcel in) {
        this.aggregateRating = in.readString();
        this.ratingText = in.readString();
        this.ratingColor = in.readString();
        this.votes = in.readString();
    }

    public static final Parcelable.Creator<RestaurantUserRating> CREATOR = new Parcelable.Creator<RestaurantUserRating>() {
        @Override
        public RestaurantUserRating createFromParcel(Parcel source) {
            return new RestaurantUserRating(source);
        }

        @Override
        public RestaurantUserRating[] newArray(int size) {
            return new RestaurantUserRating[size];
        }
    };
}
