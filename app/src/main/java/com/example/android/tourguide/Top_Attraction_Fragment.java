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


        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("Mehrangarh Fort", "hjdshfkj fdskjksl",R.drawable.mehrangarh));
        locations.add(new Location("Umaid Bhawan Palace", "hjdshfkj fdskjksl",R.drawable.umaid_palace));
        locations.add(new Location("Jaswant thade","hjdshfkj fdskjksl", R.drawable.jaswant_thada));
        locations.add(new Location("Balsamand","hjdshfkj fdskjksl", R.drawable.balsamand_lake));
        locations.add(new Location("Kaylana Lake", "hjdshfkj fdskjksl",R.drawable.kaylana));
        locations.add(new Location("Ranisar Lake","hjdshfkj fdskjksl", R.drawable.ranisar));
        locations.add(new Location("Ghanta ghar","hjdshfkj fdskjksl", R.drawable.ghanta_ghar));
        locations.add(new Location("Machia biological park", "hjdshfkj fdskjksl",R.drawable.machia_park));
        locations.add(new Location("Mandore Garden","hjdshfkj fdskjksl", R.drawable.mandore_garden));

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mAdapter = new RecyclerViewAdapter(locations);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setAdapter(mAdapter);
        return rootView;
    }

}
