package com.example.android.tourguidebucharest;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MuseumsFragment extends Fragment {


    public MuseumsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);


        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.art_collections_museum),
                getString(R.string.art_collections_museum_desc),
                getString(R.string.art_collections_museum_address),
                getString(R.string.art_collections_museum_hours),
                getString(R.string.art_collections_museum_contact),
                R.drawable.art_collections_museum));
        locations.add(new Location(getString(R.string.k_m_zambaccian),
                getString(R.string.k_m_zambaccian_desc),
                getString(R.string.k_m_zambaccian_address),
                getString(R.string.k_m_zambaccian_hours),
                getString(R.string.k_m_zambaccian_contact),
                R.drawable.k_h_zambaccian));
        locations.add(new Location(getString(R.string.theodor_pallady),
                getString(R.string.theodor_pallady_desc),
                getString(R.string.theodor_pallady_address),
                getString(R.string.theodor_pallady_hours),
                getString(R.string.theodor_pallady_contact),
                R.drawable.theodor_pallady));
        locations.add(new Location(getString(R.string.national_museum_romanian_history),
                getString(R.string.national_museum_romanian_history_desc),
                getString(R.string.national_museum_romanian_history_address),
                getString(R.string.national_museum_romanian_history_hours),
                getString(R.string.national_museum_romanian_history_contact),
                R.drawable.mnir));
        locations.add(new Location(getString(R.string.theodor_aman),
                getString(R.string.theodor_aman_desc),
                getString(R.string.theodor_aman_address),
                getString(R.string.theodor_aman_hours),
                getString(R.string.theodor_aman_contact),
                R.drawable.theodor_aman));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        GridView gridView = (GridView) rootView.findViewById(R.id.list);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Location location = locations.get(position);
                Intent selectedLocation = new Intent(getActivity(), LocationActivity.class);
                selectedLocation.putExtra("LOCATION", location);
                startActivity(selectedLocation);
            }
        });

        return rootView;
    }

}
