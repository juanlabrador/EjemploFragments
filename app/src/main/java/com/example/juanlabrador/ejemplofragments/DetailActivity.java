package com.example.juanlabrador.ejemplofragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by juanlabrador on 06/10/14.
 */
public class DetailActivity extends FragmentActivity {

    public static final String TEXT_EXTRA = "com.example.juanlabrador.ejemplofragments.TEXT_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        EmailDetailsFragment detailsFragment = (EmailDetailsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentDetails);

        detailsFragment.showDetails(getIntent().getStringExtra(TEXT_EXTRA));
    }
}
