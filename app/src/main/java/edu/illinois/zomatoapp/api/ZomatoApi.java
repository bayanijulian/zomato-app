package edu.illinois.zomatoapp.api;

import java.util.concurrent.ExecutionException;

import edu.illinois.zomatoapp.api.restaurant.Restaurant;
import edu.illinois.zomatoapp.api.restaurant.RestaurantCollection;

/**
 * Created by bayanijulian on 11/1/17.
 */

public class ZomatoApi {

    public static Restaurant[] getRestaurants(int offset){

        ZomatoAsyncTask zomatoAsyncTask = new ZomatoAsyncTask();
        zomatoAsyncTask.execute(getUrlFromOffset(offset));

        try {
            RestaurantCollection restaurantCollection = zomatoAsyncTask.get();
            return restaurantCollection.getRestaurants();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String getUrlFromOffset(int offset){
        ZomatoUrl zomatoUrl = new ZomatoUrl();
        zomatoUrl.addKeyValuePair("entity_id", "685");
        zomatoUrl.addKeyValuePair("entity_type", "city");
        zomatoUrl.addKeyValuePair("start", "" + offset);
        zomatoUrl.addKeyValuePair("cuisines","73,1");

        return zomatoUrl.getUrl();
    }
}
