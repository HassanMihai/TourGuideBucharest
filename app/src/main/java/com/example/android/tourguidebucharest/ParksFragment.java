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
public class ParksFragment extends Fragment {


    public ParksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);


        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.herastrau_park),
                getString(R.string.herastrau_park_desc),
                getString(R.string.herastrau_park_address),
                R.drawable.herastrau_park));
        locations.add(new Location(getString(R.string.tei_park),
                getString(R.string.tei_park_desc),
                getString(R.string.tei_park_address),
                R.drawable.tei_park));
        locations.add(new Location(getString(R.string.circus_park),
                getString(R.string.circus_park_desc),
                getString(R.string.circus_park_address),
                R.drawable.circus_park));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        GridView gridView = (GridView) rootView.findViewById(R.id.list);

        gridView.setAdapter(adapter);

        // OnClickListener that send selected object with Parcelable to LocationActivity
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
