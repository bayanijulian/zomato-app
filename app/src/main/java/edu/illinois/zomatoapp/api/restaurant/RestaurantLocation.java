package edu.illinois.zomatoapp.api.restaurant;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class RestaurantLocation implements Parcelable {
    private String address;
    private String locality;
    private String city;
    @SerializedName("city_id")
    private int cityId;
    private String latitude;
    private String longitude;
    private String zipcode;
    @SerializedName("country_id")
    private int countryId;
    @SerializedName("locality_verbose")
    private String localityVerbose;

    public String getAddress() {
        return address;
    }

    public String getLocality() {
        return locality;
    }

    public String getCity() {
        return city;
    }

    public int getCityId() {
        return cityId;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getZipcode() {
        return zipcode;
    }

    public int getCountryId() {
        return countryId;
    }

    public String getLocalityVerbose() {
        return localityVerbose;
    }

    /* Below code was automatically generated from the parcelable plugin */

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.address);
        dest.writeString(this.locality);
        dest.writeString(this.city);
        dest.writeInt(this.cityId);
        dest.writeString(this.latitude);
        dest.writeString(this.longitude);
        dest.writeString(this.zipcode);
        dest.writeInt(this.countryId);
        dest.writeString(this.localityVerbose);
    }

    public RestaurantLocation() {
    }

    protected RestaurantLocation(Parcel in) {
        this.address = in.readString();
        this.locality = in.readString();
        this.city = in.readString();
        this.cityId = in.readInt();
        this.latitude = in.readString();
        this.longitude = in.readString();
        this.zipcode = in.readString();
        this.countryId = in.readInt();
        this.localityVerbose = in.readString();
    }

    public static final Parcelable.Creator<RestaurantLocation> CREATOR = new Parcelable.Creator<RestaurantLocation>() {
        @Override
        public RestaurantLocation createFromParcel(Parcel source) {
            return new RestaurantLocation(source);
        }

        @Override
        public RestaurantLocation[] newArray(int size) {
            return new RestaurantLocation[size];
        }
    };
}
