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
public class Temples_Fragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public Temples_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);


        final ArrayList<Location> temples = new ArrayList<>();
        String locationDescription = getResources().getString(R.string.location_description);
        temples.add(new Location("Raj Ranchhodji Temple", locationDescription, R.drawable.raj_ranchhodji_temple));
        temples.add(new Location("Rasik Bihari Temple", locationDescription, R.drawable.rasik_bihari_temple));
        temples.add(new Location("Chamunda Mata Temple", locationDescription, R.drawable.chamunda_maa_temple));
        temples.add(new Location("Kunj Bihari Temple", locationDescription, R.drawable.kunj_bihari_temple));
        temples.add(new Location("Siddheshwar Mahadev Temple", locationDescription, R.drawable.siddheshwar_mahadev_mandir));
        temples.add(new Location("Ganesh Temple", locationDescription, R.drawable.shri_ganesh_temple));
        temples.add(new Location("Baba Ramdev Temple", locationDescription, R.drawable.baba_ramdev_temple));

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mAdapter = new RecyclerViewAdapter(temples, getActivity());
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setAdapter(mAdapter);
        return rootView;

    }

}
