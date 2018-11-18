package com.example.android.tourguide;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.LocationViewHolder> {
    private static String LOG_TAG = RecyclerViewAdapter.class.getName();

    ArrayList<Location> mArrayList;
    Context context;

    public RecyclerViewAdapter(ArrayList<Location> arrayList, Context context) {
        this.context = context;
        mArrayList = arrayList;
    }

    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        LocationViewHolder locationViewHolder = new LocationViewHolder(view, mArrayList, context);
        Log.d(LOG_TAG, "In onCreateViewHolder");
        return locationViewHolder;
    }

    @Override
    public void onBindViewHolder(LocationViewHolder holder, int position) {
        Location location = mArrayList.get(position);
        holder.locationTextView.setText(location.getMlocationName());
        holder.locationImage.setImageResource(location.getmImageResourceId());
        holder.locationDescription.setText(location.getMlocationDescription());


        Log.d(LOG_TAG, "In onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public static class LocationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView locationImage;
        TextView locationTextView, locationDescription;
        ToggleButton favButton;
        ArrayList<Location> locationsList = new ArrayList<>();
        Context context;

        public LocationViewHolder(View view, ArrayList<Location> locations, final Context context) {
            super(view);
            //Initialization
            locationsList = locations;
            this.context = context;

            //Setting Click Listener on each Card View i.e Viewholder
            view.setOnClickListener(this);

            //Setting References
            locationTextView = (TextView) view.findViewById(R.id.locationName);
            locationImage = (ImageView) view.findViewById(R.id.imageView);
            locationDescription = (TextView) view.findViewById(R.id.locationDescription);
            favButton = (ToggleButton) view.findViewById(R.id.favButton);

            favButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Checking the state of toggle button i.e favButton
                    boolean pressedState = ((ToggleButton) v).isChecked();

                    if (pressedState == true) {
                        Toast.makeText(context, "Added to favourite", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Removed from favourite", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        @Override
        public void onClick(View v) {
            //Getting adapter position and getting Location object based on that position in arraylist
            int position = getAdapterPosition();
            Location clickedLocation = locationsList.get(position);

            //Intent to start Details Activity from clicked item
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("location_name", clickedLocation.getMlocationName());
            intent.putExtra("location_image", clickedLocation.getmImageResourceId());
            this.context.startActivity(intent);
        }
    }
}
