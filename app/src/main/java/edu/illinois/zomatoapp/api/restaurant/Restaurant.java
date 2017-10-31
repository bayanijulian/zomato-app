package edu.illinois.zomatoapp.api.restaurant;

import com.google.gson.annotations.SerializedName;

public class Restaurant {
    @SerializedName("R")
    private RestaurantId restaurantId;
    @SerializedName("apikey")
    private String apiKey;
    private String id;
    private String name;
    private String url;
    private RestaurantLocation location;
    @SerializedName("switch_to_order_menu")
    private int switchToOrderMenu;
    private String cuisines;
    @SerializedName("average_cost_for_two")
    private int averageCostForTwo;
    @SerializedName("price_range")
    private int priceRange;
    private String currency;
    private String[] offers;
    private String thumb;
    @SerializedName("user_rating")
    private RestaurantUserRating userRating;
    @SerializedName("photos_url")
    private String photosUrl;
    @SerializedName("menu_url")
    private String menuUrl;
    @SerializedName("featured_image")
    private String featuredImageUrl;
    @SerializedName("has_online_delivery")
    private int hasOnlineDelivery;
    @SerializedName("is_delivering_now")
    private int isDeliveringNow;
    @SerializedName("deeplink")
    private String deepLink;
    @SerializedName("has_table_booking")
    private int hasTableBooking;
    @SerializedName("events_url")
    private String eventsUrl;
    @SerializedName("establishment_types")
    private String[] establishmentTypes;

    public RestaurantId getRestaurantId() {
        return restaurantId;
    }

    public String getName() {
        return name;
    }

    public String getId(){
        return id;
    }

    public String getUrl() {
        return url;
    }

    public RestaurantLocation getLocation() {
        return location;
    }

    public int getSwitchToOrderMenu() {
        return switchToOrderMenu;
    }

    public String getCuisines() {
        return cuisines;
    }

    public int getAverageCostForTwo() {
        return averageCostForTwo;
    }

    public int getPriceRange() {
        return priceRange;
    }

    public String getCurrency() {
        return currency;
    }

    public RestaurantUserRating getUserRating() {
        return userRating;
    }

    public String getPhotosUrl() {
        return photosUrl;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public String getFeaturedImageUrl() {
        return featuredImageUrl;
    }

    public int hasOnlineDelivery() {
        return hasOnlineDelivery;
    }

    public int isDeliveringNow() {
        return isDeliveringNow;
    }

    public String getDeepLink() {
        return deepLink;
    }

    public int hasTableBooking() {
        return hasTableBooking;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }
}
