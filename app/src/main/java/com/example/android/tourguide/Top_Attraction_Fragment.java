package com.example.android.tourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Top_Attraction_Fragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public Top_Attraction_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        String locationDescription = getResources().getString(R.string.location_description);

        //Creating an arraylist for locations
        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("Mehrangarh Fort", locationDescription, R.drawable.mehrangarh));
        locations.add(new Location("Umaid Bhawan Palace", locationDescription, R.drawable.umaid_palace));
        locations.add(new Location("Jaswant thade", locationDescription, R.drawable.jaswant_thada));
        locations.add(new Location("Balsamand", locationDescription, R.drawable.balsamand_lake));
        locations.add(new Location("Kaylana Lake", locationDescription, R.drawable.kaylana));
        locations.add(new Location("Ranisar Lake", locationDescription, R.drawable.ranisar));
        locations.add(new Location("Ghanta ghar", locationDescription, R.drawable.ghanta_ghar));
        locations.add(new Location("Machia biological park", locationDescription, R.drawable.machia_park));
        locations.add(new Location("Mandore Garden", locationDescription, R.drawable.mandore_garden));

        //getting the reference of recyclerView
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        //Instantiating Adapter and LayoutManager
        mAdapter = new RecyclerViewAdapter(locations, getActivity());
        mLayoutManager = new LinearLayoutManager(getActivity());

        //Attaching LayoutManager with RecyclerView
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        //Setting adapter with RecyclerView
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

}
