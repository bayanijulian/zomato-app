package edu.illinois.zomatoapp;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import edu.illinois.zomatoapp.api.restaurant.RestaurantCollection;
import edu.illinois.zomatoapp.api.restaurant.RestaurantHolder;

public class ZomatoAsyncTask extends AsyncTask<String, Integer, RestaurantCollection> {
    private static final String TAG = ZomatoAsyncTask.class.getSimpleName();

    @Override
    protected RestaurantCollection doInBackground(String... urls) {
        try {
            URL url = new URL(urls[0]);

            URLConnection connection = url.openConnection();
            connection.setRequestProperty("user-key", "4695ebe6dd338e0cb28f8017424616b4");
            connection.connect();

            InputStream inStream = connection.getInputStream();
            InputStreamReader inStreamReader = new InputStreamReader(inStream, Charset.forName("UTF-8"));

            Gson gson = new Gson();
            RestaurantCollection restaurantCollection = gson.fromJson(inStreamReader, RestaurantCollection.class);

            return restaurantCollection;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(RestaurantCollection restaurantCollection) {
        if(restaurantCollection == null) {
            return;
        }

        for(RestaurantHolder restaurantHolders : restaurantCollection.getRestaurantHolders()) {
            Log.d(TAG, "onPostExecute: " + restaurantHolders.getRestaurant());
        }
    }
}
