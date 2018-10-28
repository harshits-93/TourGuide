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

        temples.add(new Location("Raj Ranchhodji Temple","hjdshfkj fdskjksl", R.drawable.raj_ranchhodji_temple));
        temples.add(new Location("Rasik Bihari Temple", "hjdshfkj fdskjksl",R.drawable.rasik_bihari_temple));
        temples.add(new Location("Chamunda Mata Temple","hjdshfkj fdskjksl", R.drawable.chamunda_maa_temple));
        temples.add(new Location("Kunj Bihari Temple", "hjdshfkj fdskjksl",R.drawable.kunj_bihari_temple));
        temples.add(new Location("Siddheshwar Mahadev Temple", "hjdshfkj fdskjksl",R.drawable.siddheshwar_mahadev_mandir));
        temples.add(new Location("Ganesh Temple", "hjdshfkj fdskjksl",R.drawable.shri_ganesh_temple));
        temples.add(new Location("Baba Ramdev Temple", "hjdshfkj fdskjksl",R.drawable.baba_ramdev_temple));

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mAdapter = new RecyclerViewAdapter(temples);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setAdapter(mAdapter);
        return rootView;

    }

}
