package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class TemplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        //Checking if the fragment container is null or not
        if (findViewById(R.id.container) != null) {
            /*Here checking if activity is resumed
             or created for the first time to avoid
             overlapping of fragments*/
            if (savedInstanceState != null) {
                return;
            }
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new Temples_Fragment())
                    .commit();

        }
    }
}
