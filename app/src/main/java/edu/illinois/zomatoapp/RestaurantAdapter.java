package edu.illinois.zomatoapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
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
        View restaurantItem = LayoutInflater.from(parent.getContext())
                                            .inflate(R.layout.restaurant_item, parent, false);
        return new ViewHolder(restaurantItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Restaurant restaurant = restaurants.get(position);
        holder.nameTextView.setText(restaurant.getName());
        holder.cuisineTextView.setText(restaurant.getCuisines());

        String priceRange = getPriceRangeString(restaurant.getPriceRange());
        holder.priceRangeTextView.setText(priceRange);

        String location = restaurant.getLocation().getAddress();
        holder.priceRangeTextView.setText(location);

    }

    private String getPriceRangeString(int priceRange){
        StringBuilder priceRangeSymbols = new StringBuilder();

        for(int i = 0; i < priceRange; i++){
            priceRangeSymbols.append("$");
        }

        return priceRangeSymbols.toString();
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
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
