package com.example.android.tourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Restaurants_Fragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public Restaurants_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);


        final ArrayList<Location> restaurants = new ArrayList<>();
        restaurants.add(new Location("Gypsy", "hjdshfkj fdskjksl",R.drawable.gypsy_restaurant));
        restaurants.add(new Location("On The Rocks", "hjdshfkj fdskjksl",R.drawable.on_the_rocks));
        restaurants.add(new Location("Dagley The Lounge","hjdshfkj fdskjksl", R.drawable.dagley_the_lounge));
        restaurants.add(new Location("Kalinga", "hjdshfkj fdskjksl",R.drawable.kalinga));
        restaurants.add(new Location("Kesar Heritage", "hjdshfkj fdskjksl",R.drawable.kesar_heritage));
        restaurants.add(new Location("Skyzz", "hjdshfkj fdskjksl",R.drawable.skyzz));
        restaurants.add(new Location("Royal Tarka","hjdshfkj fdskjksl", R.drawable.royal_tarka));

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mAdapter = new RecyclerViewAdapter(restaurants);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setAdapter(mAdapter);
        return rootView;

    }

}
