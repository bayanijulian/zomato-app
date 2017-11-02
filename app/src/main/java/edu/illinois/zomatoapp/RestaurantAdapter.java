package edu.illinois.zomatoapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.illinois.zomatoapp.api.restaurant.Restaurant;

/**
 * Created by bayanijulian on 11/1/17.
 */

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private List<Restaurant> restaurants;

    public RestaurantAdapter(Restaurant[] restaurants) {
        this.restaurants = new ArrayList<>();
        this.restaurants.addAll(Arrays.asList(restaurants));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View itemView;
        public TextView nameTextView;
        public TextView cuisineTextView;
        public TextView priceRangeTextView;
        public TextView addressTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.nameTextView = (TextView) itemView.findViewById(R.id.restaurantNameTextView);
            this.cuisineTextView = (TextView) itemView.findViewById(R.id.restaurantCuisineTextView);
            this.priceRangeTextView = (TextView) itemView.findViewById(R.id.restaurantPriceRangeTextView);
            this.addressTextView = (TextView) itemView.findViewById(R.id.restaurantAddressTextView);
        }
    }
}
