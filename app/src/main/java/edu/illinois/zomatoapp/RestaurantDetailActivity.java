package edu.illinois.zomatoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import edu.illinois.zomatoapp.api.restaurant.Restaurant;

/**
 * Created by bayanijulian on 11/7/17.
 */

public class RestaurantDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);

        Intent intent = getIntent();
        Restaurant restaurant = intent.getParcelableExtra(RestaurantAdapter.EXTRA_RESTAURANT);
        final TextView name = (TextView) findViewById(R.id.restaurantDetailNameTextView);
        name.setText(restaurant.getName());

    }
}
