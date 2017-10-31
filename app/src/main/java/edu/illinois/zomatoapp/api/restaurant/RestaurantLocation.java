package edu.illinois.zomatoapp.api.restaurant;

import com.google.gson.annotations.SerializedName;

public class RestaurantLocation {
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
}
