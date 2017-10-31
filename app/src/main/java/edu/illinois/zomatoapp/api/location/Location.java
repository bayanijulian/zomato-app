package edu.illinois.zomatoapp.api.location;

import com.google.gson.annotations.SerializedName;

public class Location {
    private int id;
    private String name;
    @SerializedName("country_id")
    private int countryId;
    @SerializedName("country_name")
    private String countryName;
    @SerializedName("should_experiment_with")
    private int shouldExperimentWith;
    @SerializedName("discovery_enabled")
    private int discoveryEnabled;
    @SerializedName("has_new_ad_format")
    private int hasNewAdFormat;
    @SerializedName("is_state")
    private int isState;
    @SerializedName("state_id")
    private int stateId;
    @SerializedName("state_name")
    private String stateName;
    @SerializedName("state_code")
    private String stateCode;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCountryId() {
        return countryId;
    }

    public String getCountryName(){
        return countryName;
    }

    public int shouldExperimentWith() {
        return shouldExperimentWith;
    }

    public int isDiscoveryEnabled() {
        return discoveryEnabled;
    }

    public int hasNewAdFormat() {
        return hasNewAdFormat;
    }

    public int isState() {
        return isState;
    }

    public int getStateId() {
        return stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public String getStateCode() {
        return stateCode;
    }
}
