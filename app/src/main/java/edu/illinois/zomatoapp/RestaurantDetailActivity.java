package edu.illinois.zomatoapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
        final Restaurant restaurant = intent.getParcelableExtra(RestaurantAdapter.EXTRA_RESTAURANT);
        final TextView nameTxt = (TextView) findViewById(R.id.restaurantDetailNameTextView);
        final TextView cuisineTxt = (TextView) findViewById(R.id.restaurantDetailCuisinesTextView);
        final TextView priceRangeTxt = (TextView) findViewById(R.id.restaurantDetailPriceRangeTextView);
        final TextView averagePriceTxt = (TextView) findViewById(R.id.restaurantDetailAveragePriceTextView);
        final TextView locationTxt = (TextView) findViewById(R.id.restaurantDetailLocationTextView);


        String averagePrice = ""  + restaurant.getAverageCostForTwo();

        nameTxt.setText(restaurant.getName());
        cuisineTxt.setText(restaurant.getCuisines());
        priceRangeTxt.setText(getPriceRangeString(restaurant.getPriceRange()));
        averagePriceTxt.setText(averagePrice);
        locationTxt.setText(restaurant.getLocation().getAddress());

        final Button websiteBtn = (Button) findViewById(R.id.restaurantDetailWebsiteBtn);
        final Button mapBtn = (Button) findViewById(R.id.restaurantDetailMapBtn);

        websiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri websiteUri = Uri.parse(restaurant.getUrl());
                Intent webIntent = new Intent(Intent.ACTION_VIEW, websiteUri);

                if(webIntent.resolveActivity(getPackageManager())!=null){
                    startActivity(webIntent);
                }
            }
        });

        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String restaurantNameAsUri = restaurant.getName().replace(' ', '+');
                Uri locationUri = Uri.parse("geo:0,0?q=" + restaurantNameAsUri);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, locationUri);

                if(mapIntent.resolveActivity(getPackageManager())!=null){
                    startActivity(mapIntent);
                }
            }
        });
    }

    private String getPriceRangeString(int priceRange) {
        StringBuilder priceRangeSymbols = new StringBuilder();

        for (int i = 0; i < priceRange; i++) {
            priceRangeSymbols.append("$");
        }

        return priceRangeSymbols.toString();
    }
}
