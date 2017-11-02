package edu.illinois.zomatoapp.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bayanijulian on 11/1/17.
 */

public class ZomatoUrl {
    private static final String URL = "https://developers.zomato.com/api/v2.1/search?";

    private List<String> keys;
    private List<String> values;
    private int size;

    public ZomatoUrl() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
        size = 0;
    }

    /**
     * This function returns a url for the zomato api
     * with the given key and values.
     *
     * @return the url with the given keys and values
     */
    public String getUrl() {
        StringBuilder url = new StringBuilder(URL);

        for (int i = 0; i < size; i++) {
            url.append(getKey(i)).append("=").append(getValue(i)).append("&");
        }

        return url.toString();
    }

    /**
     * This function adds keys and values to a list to create
     * a url in the getUrl function.
     *
     * @param key   a key for the url
     * @param value corresponding value for the key
     */
    public void addKeyValuePair(String key, String value) {
        keys.add(key);
        values.add(value);
        size += 1;
    }

    private String getKey(int index) {
        return keys.get(index);
    }

    private String getValue(int index) {
        return values.get(index);
    }

}
