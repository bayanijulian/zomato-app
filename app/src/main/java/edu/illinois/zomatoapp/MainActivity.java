package edu.illinois.zomatoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.concurrent.ExecutionException;

import edu.illinois.zomatoapp.api.restaurant.Restaurant;
import edu.illinois.zomatoapp.api.restaurant.RestaurantCollection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ZomatoUrl zomatoUrl = new ZomatoUrl();
        zomatoUrl.addKeyValuePair("entity_id", "685");
        zomatoUrl.addKeyValuePair("entity_type", "city");
        zomatoUrl.addKeyValuePair("start", "0");
        zomatoUrl.addKeyValuePair("cuisines","73");
        String url = zomatoUrl.getUrl();

        ZomatoAsyncTask zomatoAsyncTask = new ZomatoAsyncTask();
        zomatoAsyncTask.execute(url);

        Restaurant[] restaurants;
        try {
            RestaurantCollection restaurantCollection = zomatoAsyncTask.get();
            restaurants = restaurantCollection.getRestaurants();

            final RestaurantAdapter restaurantAdapter = new RestaurantAdapter(restaurants);
            final RecyclerView restaurantList = (RecyclerView) findViewById(R.id.restaurantList);

            restaurantList.setAdapter(restaurantAdapter);
            restaurantList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }



    }
}
