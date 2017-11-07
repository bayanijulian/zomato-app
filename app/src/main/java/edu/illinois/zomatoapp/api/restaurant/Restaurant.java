package edu.illinois.zomatoapp.api.restaurant;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Restaurant implements Parcelable {
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

    public String[] getOffers() {
        return offers;
    }

    public String getThumb() {
        return thumb;
    }

    public int getHasOnlineDelivery() {
        return hasOnlineDelivery;
    }

    public int getIsDeliveringNow() {
        return isDeliveringNow;
    }

    public int getHasTableBooking() {
        return hasTableBooking;
    }

    public String[] getEstablishmentTypes() {
        return establishmentTypes;
    }

    /* Below code was automatically generated from the parcelable plugin */

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.restaurantId, flags);
        dest.writeString(this.apiKey);
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.url);
        dest.writeParcelable(this.location, flags);
        dest.writeInt(this.switchToOrderMenu);
        dest.writeString(this.cuisines);
        dest.writeInt(this.averageCostForTwo);
        dest.writeInt(this.priceRange);
        dest.writeString(this.currency);
        dest.writeStringArray(this.offers);
        dest.writeString(this.thumb);
        dest.writeParcelable(this.userRating, flags);
        dest.writeString(this.photosUrl);
        dest.writeString(this.menuUrl);
        dest.writeString(this.featuredImageUrl);
        dest.writeInt(this.hasOnlineDelivery);
        dest.writeInt(this.isDeliveringNow);
        dest.writeString(this.deepLink);
        dest.writeInt(this.hasTableBooking);
        dest.writeString(this.eventsUrl);
        dest.writeStringArray(this.establishmentTypes);
    }

    public Restaurant() {
    }

    protected Restaurant(Parcel in) {
        this.restaurantId = in.readParcelable(RestaurantId.class.getClassLoader());
        this.apiKey = in.readString();
        this.id = in.readString();
        this.name = in.readString();
        this.url = in.readString();
        this.location = in.readParcelable(RestaurantLocation.class.getClassLoader());
        this.switchToOrderMenu = in.readInt();
        this.cuisines = in.readString();
        this.averageCostForTwo = in.readInt();
        this.priceRange = in.readInt();
        this.currency = in.readString();
        this.offers = in.createStringArray();
        this.thumb = in.readString();
        this.userRating = in.readParcelable(RestaurantUserRating.class.getClassLoader());
        this.photosUrl = in.readString();
        this.menuUrl = in.readString();
        this.featuredImageUrl = in.readString();
        this.hasOnlineDelivery = in.readInt();
        this.isDeliveringNow = in.readInt();
        this.deepLink = in.readString();
        this.hasTableBooking = in.readInt();
        this.eventsUrl = in.readString();
        this.establishmentTypes = in.createStringArray();
    }

    public static final Parcelable.Creator<Restaurant> CREATOR = new Parcelable.Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel source) {
            return new Restaurant(source);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };
}
