package edu.illinois.zomatoapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.illinois.zomatoapp.api.restaurant.RestaurantHolder;

/**
 * Created by bayanijulian on 11/1/17.
 */

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private List<RestaurantHolder> restaurants;

    public RestaurantAdapter(RestaurantHolder[] restaurants){
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

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
