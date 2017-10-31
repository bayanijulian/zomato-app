package edu.illinois.zomatoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "https://developers.zomato.com/api/v2.1/search?entity_id=685&entity_type=city&start=0&cuisines=73";

        ZomatoAsyncTask zomatoAsyncTask = new ZomatoAsyncTask();
        zomatoAsyncTask.execute(url);
    }
}
