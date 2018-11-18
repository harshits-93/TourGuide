package com.example.android.tourguide;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView description;
    Button locationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        //References
        imageView = (ImageView) findViewById(R.id.image);
        description = (TextView) findViewById(R.id.place_detail);
        locationButton = (Button) findViewById(R.id.btn_location);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        // Set title of Detail page
        collapsingToolbar.setTitle(getIntent().getStringExtra("location_name"));

        Resources resources = getResources();
        String locationDescription = resources.getString(R.string.location_description);
        description.setText(locationDescription);
        imageView.setImageResource(getIntent().getIntExtra("location_image", 0));

        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //default location string
                String locationString = "Mehrangarh Fort,Jodhpur";

                //Using Uri builder to build uri for address of location
                Uri.Builder builder = new Uri.Builder();
                builder.scheme("geo")
                        .path("0,0")
                        .query(locationString);
                Uri addressUri = builder.build();

                //Implicit intent to start appropriate map apps to access location
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(addressUri);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

    }
}
