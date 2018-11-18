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
public class Hotels_Fragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public Hotels_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);


        final ArrayList<Location> hotels = new ArrayList<>();
        String locationDescription = getResources().getString(R.string.location_description);
        hotels.add(new Location("Umaid Bhawan", locationDescription, R.drawable.umaid_bhawan));
        hotels.add(new Location("Amargarh Resort", locationDescription, R.drawable.amargarh_resort));
        hotels.add(new Location("Lariya Resort", locationDescription, R.drawable.lariya_resort));
        hotels.add(new Location("Lords Inn", locationDescription, R.drawable.lords_inn));
        hotels.add(new Location("Pratap Niwas", locationDescription, R.drawable.pratap_niwas));
        hotels.add(new Location("Kalinga", locationDescription, R.drawable.kalinga));
        hotels.add(new Location("Marvel Umed Hotel", locationDescription, R.drawable.marvel_umed_hotel));

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mAdapter = new RecyclerViewAdapter(hotels, getActivity());
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setAdapter(mAdapter);
        return rootView;

    }

}
