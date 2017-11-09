package edu.illinois.zomatoapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.illinois.zomatoapp.api.restaurant.Restaurant;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {
    public static final String EXTRA_RESTAURANT = "edu.illinois.zomatoapp.RESTAURANT";

    private List<Restaurant> restaurants;

    public RestaurantAdapter(Restaurant[] restaurants) {
        this.restaurants = new ArrayList<>();
        this.restaurants.addAll(Arrays.asList(restaurants));
    }

    /**
     * This function adds more data to view and notifies
     * the adapter that there is more data.
     *
     * @param restaurants the list of restaurants to add
     */
    public void addRestaurants(Restaurant[] restaurants) {
        this.restaurants.addAll(Arrays.asList(restaurants));
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View restaurantItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.restaurant_item, parent, false);
        return new ViewHolder(restaurantItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Restaurant restaurant = restaurants.get(position);
        holder.nameTextView.setText(restaurant.getName());
        holder.cuisineTextView.setText(restaurant.getCuisines());

        SpannableStringBuilder priceRange = getPriceRangeString(restaurant.getPriceRange());
        holder.priceRangeTextView.setText(priceRange);

        String address = restaurant.getLocation().getAddress();
        holder.addressTextView.setText(address);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Context context = view.getContext();
                Intent restaurantDetailIntent = new Intent(context, RestaurantDetailActivity.class);
                restaurantDetailIntent.putExtra(EXTRA_RESTAURANT, restaurant);
                context.startActivity(restaurantDetailIntent);
            }
        });
    }

    private SpannableStringBuilder getPriceRangeString(int numDollarSigns) {
        String priceRangeTxt = ("- $$$$");
        int START_INDEX = priceRangeTxt.indexOf("$");
        int END_INDEX = START_INDEX + numDollarSigns;

        //code below derived from
        //https://stackoverflow.com/questions/14371092/how-to-make-a-specific-text-on-textview-bold
        SpannableStringBuilder str = new SpannableStringBuilder(priceRangeTxt);

        //makes the specified amount of dollar signs bold
        str.setSpan(new StyleSpan(Typeface.BOLD),
                START_INDEX, END_INDEX, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        str.setSpan(new ForegroundColorSpan(Color.LTGRAY),
                END_INDEX, priceRangeTxt.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return str;
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
