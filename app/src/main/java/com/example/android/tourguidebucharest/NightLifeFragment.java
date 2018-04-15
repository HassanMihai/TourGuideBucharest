package com.example.android.tourguidebucharest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NightLifeFragment extends Fragment {


    public NightLifeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);


        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location("Night name", "desc", "buch", "10", "aaa" ));
        locations.add(new Location("loc name", "desc", "buch", "10", "aaa" ));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        GridView gridView = (GridView) rootView.findViewById(R.id.list);

        gridView.setAdapter(adapter);

        return rootView;
    }

}
