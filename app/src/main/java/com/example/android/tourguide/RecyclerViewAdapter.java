package com.example.android.tourguide;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.LocationViewHolder> {
    ArrayList<Location> mArrayList;

    public RecyclerViewAdapter(ArrayList<Location> arrayList) {
        mArrayList = arrayList;
    }

    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        LocationViewHolder locationViewHolder = new LocationViewHolder(view);

        return locationViewHolder;
    }

    @Override
    public void onBindViewHolder(LocationViewHolder holder, int position) {
        Location location = mArrayList.get(position);
        holder.locationTextView.setText(location.getMlocationName());
        holder.locationImage.setImageResource(location.getmImageResourceId());
        holder.locationDescription.setText(location.getMlocationDescription());
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public static class LocationViewHolder extends RecyclerView.ViewHolder {
        ImageView locationImage;
        TextView locationTextView,locationDescription;


        public LocationViewHolder(View view) {
            super(view);
            locationTextView = (TextView) view.findViewById(R.id.locationName);
            locationImage = (ImageView) view.findViewById(R.id.image);
            locationDescription= (TextView) view.findViewById(R.id.locationDescription);
        }

    }
}
