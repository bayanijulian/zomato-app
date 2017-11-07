package edu.illinois.zomatoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.concurrent.ExecutionException;

import edu.illinois.zomatoapp.api.ZomatoApi;
import edu.illinois.zomatoapp.api.restaurant.Restaurant;
import edu.illinois.zomatoapp.api.restaurant.RestaurantCollection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Restaurant[] restaurants = ZomatoApi.getRestaurants(0);

        final RestaurantAdapter restaurantAdapter = new RestaurantAdapter(restaurants);
        final RecyclerView restaurantList = (RecyclerView) findViewById(R.id.restaurantList);

        restaurantList.setAdapter(restaurantAdapter);
        restaurantList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

}
