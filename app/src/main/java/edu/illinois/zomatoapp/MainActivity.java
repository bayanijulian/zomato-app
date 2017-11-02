package edu.illinois.zomatoapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.concurrent.ExecutionException;

import edu.illinois.zomatoapp.api.restaurant.Restaurant;
import edu.illinois.zomatoapp.api.restaurant.RestaurantCollection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "https://developers.zomato.com/api/v2.1/search?entity_id=685&entity_type=city&start=0&cuisines=73";

        ZomatoAsyncTask zomatoAsyncTask = new ZomatoAsyncTask();
        zomatoAsyncTask.execute(url);
        try {
            RestaurantCollection restaurantCollection = zomatoAsyncTask.get();
            Restaurant[] restaurants = restaurantCollection.getRestaurants();
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
