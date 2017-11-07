package edu.illinois.zomatoapp.api.restaurant;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class RestaurantId implements Parcelable {
    @SerializedName("res_id")
    private int restaurantId;

    public int getRestaurantId() {
        return restaurantId;
    }

    /* Below code was automatically generated from the parcelable plugin */

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.restaurantId);
    }

    public RestaurantId() {
    }

    protected RestaurantId(Parcel in) {
        this.restaurantId = in.readInt();
    }

    public static final Parcelable.Creator<RestaurantId> CREATOR = new Parcelable.Creator<RestaurantId>() {
        @Override
        public RestaurantId createFromParcel(Parcel source) {
            return new RestaurantId(source);
        }

        @Override
        public RestaurantId[] newArray(int size) {
            return new RestaurantId[size];
        }
    };
}
