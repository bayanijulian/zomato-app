package edu.illinois.zomatoapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.illinois.zomatoapp.api.restaurant.Restaurant;


public class RestaurantDetailActivity extends AppCompatActivity {
    private TextView nameTxt;
    private TextView cuisineTxt;
    private TextView priceRangeTxt;
    private TextView averagePriceTxt;
    private TextView locationTxt;

    private Button websiteBtn;
    private Button mapBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);

        Intent intent = getIntent();
        final Restaurant restaurant = intent.getParcelableExtra(RestaurantAdapter.EXTRA_RESTAURANT);

        createTextViews();
        bindDataToTextViews(restaurant);

        createButtons();
        createButtonListeners(restaurant);
    }

    private void createButtons() {
        websiteBtn = (Button) findViewById(R.id.restaurantDetailWebsiteBtn);
        mapBtn = (Button) findViewById(R.id.restaurantDetailMapBtn);
    }

    private void createTextViews() {
        nameTxt = (TextView) findViewById(R.id.restaurantDetailNameTextView);
        cuisineTxt = (TextView) findViewById(R.id.restaurantDetailCuisinesTextView);
        priceRangeTxt = (TextView) findViewById(R.id.restaurantDetailPriceRangeTextView);
        averagePriceTxt = (TextView) findViewById(R.id.restaurantDetailAveragePriceTextView);
        locationTxt = (TextView) findViewById(R.id.restaurantDetailLocationTextView);
    }

    private void bindDataToTextViews(Restaurant restaurant) {
        nameTxt.setText(restaurant.getName());
        cuisineTxt.setText(restaurant.getCuisines());


        SpannableStringBuilder priceRange = getPriceRangeString(restaurant.getPriceRange());
        priceRangeTxt.setText(priceRange);

        String averagePrice = getString(R.string.average_price_for_two) + " - " +
                restaurant.getAverageCostForTwo();
        averagePriceTxt.setText(averagePrice);

        String location = restaurant.getLocation().getAddress();
        locationTxt.setText(location);
    }

    private SpannableStringBuilder getPriceRangeString(int numDollarSigns) {
        String priceRangeTxt = getString(R.string.price_range);
        int START_INDEX = priceRangeTxt.indexOf("$");
        int END_INDEX = START_INDEX + numDollarSigns;

        //code below derived from
        //https://stackoverflow.com/questions/14371092/how-to-make-a-specific-text-on-textview-bold
        SpannableStringBuilder str = new SpannableStringBuilder(priceRangeTxt);

        //makes the specified amount of dollar signs bold
        str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD),
                START_INDEX, END_INDEX, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return str;
    }

    private void createButtonListeners(final Restaurant restaurant) {
        //opens zomato website for the restaurant
        websiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri websiteUri = Uri.parse(restaurant.getUrl());
                Intent webIntent = new Intent(Intent.ACTION_VIEW, websiteUri);

                if (webIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(webIntent);
                }
            }
        });
        //opens map for the restaurant
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String restaurantNameAsUri = restaurant.getName().replace(' ', '+');
                Uri locationUri = Uri.parse("geo:0,0?q=" + restaurantNameAsUri);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, locationUri);

                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });
    }
}
