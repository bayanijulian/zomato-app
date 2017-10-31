package edu.illinois.zomatoapp.api;

import com.google.gson.Gson;


import java.util.ArrayList;

import edu.illinois.zomatoapp.api.cuisine.CuisineCollection;
import edu.illinois.zomatoapp.api.cuisine.CuisineHolder;
import edu.illinois.zomatoapp.api.location.Location;
import edu.illinois.zomatoapp.api.location.LocationCollection;
import edu.illinois.zomatoapp.api.restaurant.Restaurant;
import edu.illinois.zomatoapp.api.restaurant.RestaurantCollection;
import edu.illinois.zomatoapp.api.restaurant.RestaurantHolder;
import edu.illinois.zomatoapp.api.restaurant.RestaurantLocation;

public class ZomatoQuery {
//
//    public static String apiKey = ZomatoKey.API_KEY;
//
//    /**
//     * @param cityId id for the city
//     * @param start where to start in the results given
//     * @param cuisineId list of IDs for the cuisine
//     * @return the json response from zomato with the given parameters
//     */
//    public static String getZomatoJsonForRestaurants(int cityId, int start, int... cuisineId) {
//        HttpResponse<String> response;
//        final String ZOMATO_URL = "https://developers.zomato.com/api/v2.1/search?entity_id={cityId}&entity_type=city&start={start}&cuisines={cuisineId}";
//        final String CITY_ID = "" + cityId;
//        final String START = "" + start;
//
//        StringBuilder cuisineIds = new StringBuilder();
//        // code below derived from
//        // https://stackoverflow.com/questions/17837117/java-sending-multiple-parameters-to-method
//        for(int id : cuisineId) {
//            cuisineIds.append(id).append(",");
//        }
//
//        try {
//            response = Unirest.get(ZOMATO_URL)
//                    .header("user-key", apiKey)
//                    .routeParam("cityId", CITY_ID)
//                    .routeParam("cuisineId", cuisineIds.toString())
//                    .routeParam("start", START)
//                    .asString();
//
//            if(response.getStatus() == 200) {
//                return response.getBody();
//            }
//
//        } catch (UnirestException e) {
//            return e.toString();
//        }
//
//        return null;
//    }
//
//    /**
//     * @param cityName is the name of the city
//     * @param cuisineNames is the list of names of the cuisine
//     * @return list of all the restaurants within the city and with the types of food
//     */
//    public static String getListOfRestaurantsAsString(String cityName, String... cuisineNames){
//        int cityId = getCityIdFromName(cityName);
//        int[] cuisineIds = getCuisineIdsFromNames(cityId, cuisineNames);
//
//        return getListOfRestaurantsAsString(cityId, cuisineIds);
//    }
//
//    /**
//     * @param cityId is the id of the city
//     * @param cuisineId is the list of IDs of the cuisine
//     * @return list of all the restaurants within the city and with the types of food
//     */
//    public static String getListOfRestaurantsAsString(int cityId, int... cuisineId) {
//        String[] zomatoJson = getAllJson(cityId,cuisineId);
//
//        Gson gson = new Gson();
//        RestaurantCollection[] restaurantCollections = new RestaurantCollection[zomatoJson.length];
//
//        for(int i = 0 ; i < zomatoJson.length; i++) {
//            restaurantCollections[i] = gson.fromJson(zomatoJson[i], RestaurantCollection.class);
//        }
//
//        String restaurantList = "";
//
//        for(RestaurantCollection restaurantCollection: restaurantCollections) {
//            for(RestaurantHolder restaurantHolder: restaurantCollection.getRestaurantHolders()) {
//                Restaurant restaurant = restaurantHolder.getRestaurant();
//                RestaurantLocation restaurantLocation = restaurant.getLocation();
//
//                String name = restaurant.getName();
//                String cuisines = restaurant.getCuisines();
//                String address = restaurantLocation.getAddress();
//
//                restaurantList += name + "\n  " + address + "\n  " + cuisines + "\n";
//            }
//        }
//
//        if(restaurantList.equals("")) {
//            return "No Restaurants Found";
//        }
//
//        return restaurantList;
//    }
//
//    private static int[] getCuisineIdsFromNames(int cityId, String... cuisineNames) {
//        HttpResponse<String> response;
//        final String ZOMATO_URL = "https://developers.zomato.com/api/v2.1/cuisines?city_id={cityId}";
//        final String CITY_ID = "" + cityId;
//        try {
//            response = Unirest.get(ZOMATO_URL)
//                    .header("user-key", apiKey)
//                    .routeParam("cityId", CITY_ID)
//                    .asString();
//
//            if(response.getStatus() == 200) {
//                String json = response.getBody();
//                Gson gson = new Gson();
//
//                CuisineCollection cuisineCollection = gson.fromJson(json, CuisineCollection.class);
//                CuisineHolder[] cuisineHolders = cuisineCollection.getCuisineHolders();
//                ArrayList<Integer> cuisineMatches = new ArrayList<>();
//
//                //adds to list if the input name matches any cuisine in the area
//                for(String name: cuisineNames){
//                    for(CuisineHolder cuisineHolder: cuisineHolders){
//                        String nameFromZomato = cuisineHolder.getCuisine().getName();
//
//                        if(name.equalsIgnoreCase(nameFromZomato)){
//                            int id = cuisineHolder.getCuisine().getId();
//
//                            cuisineMatches.add(id);
//                        }
//                    }
//                }
//
//                return listToIntArray(cuisineMatches);
//
//            }
//
//        } catch (UnirestException e) {
//            return null;
//        }
//
//        return null;
//    }
//
//    private static int getCityIdFromName(String cityName) {
//        HttpResponse<String> response;
//        final String ZOMATO_URL = "https://developers.zomato.com/api/v2.1/cities?q={cityName}&count=1";
//
//        try {
//            response = Unirest.get(ZOMATO_URL)
//                    .header("user-key", apiKey)
//                    .routeParam("cityName", cityName)
//                    .asString();
//
//            if(response.getStatus() == 200) {
//                String json = response.getBody();
//                Gson gson = new Gson();
//
//                LocationCollection locationCollection = gson.fromJson(json, LocationCollection.class);
//                Location[] location = locationCollection.getLocations();
//
//                if(location != null) {
//                    return location[0].getId();
//                }
//            }
//
//        } catch (UnirestException e) {
//            return -1;
//        }
//
//        return -1;
//    }
//
//    private static String[] getAllJson(int cityId, int... cuisineId) {
//        String[] allZomatoJson;
//        final int MAX_RESULTS_FROM_ZOMATO = 20;
//
//        String firstZomatoJson = getZomatoJsonForRestaurants(cityId, 0, cuisineId);
//        Gson gson = new Gson();
//        RestaurantCollection restaurantCollection = gson.fromJson(firstZomatoJson, RestaurantCollection.class);
//        int numResults = restaurantCollection.getResultsFound();
//
//        if(numResults > MAX_RESULTS_FROM_ZOMATO) {
//            int lengthForZomatoJson;
//
//            //if there is a remainder, it will add another element for the zomato json array
//            if(numResults % MAX_RESULTS_FROM_ZOMATO == 0){
//                lengthForZomatoJson = numResults / MAX_RESULTS_FROM_ZOMATO;
//            } else {
//                lengthForZomatoJson = (numResults / MAX_RESULTS_FROM_ZOMATO) + 1;
//            }
//
//            allZomatoJson = new String[lengthForZomatoJson];
//            allZomatoJson[0] = firstZomatoJson;
//
//            for(int i = 1; i < allZomatoJson.length; i++){
//                int newStart = MAX_RESULTS_FROM_ZOMATO * i;
//                allZomatoJson[i] = getZomatoJsonForRestaurants(cityId, newStart, cuisineId);
//            }
//        } else {
//            allZomatoJson = new String[1];
//            allZomatoJson[0] = firstZomatoJson;
//        }
//
//        return allZomatoJson;
//    }
//
//    private static int[] listToIntArray(ArrayList<Integer> list) {
//        int[] newList = new int[list.size()];
//
//        for(int i = 0; i < newList.length; i++){
//            newList[i] = list.get(i);
//        }
//
//        return newList;
//    }

}
