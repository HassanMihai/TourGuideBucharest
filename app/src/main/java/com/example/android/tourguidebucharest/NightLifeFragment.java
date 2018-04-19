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
        locations.add(new Location(getString(R.string.mojo),
                getString(R.string.mojo_desc),
                getString(R.string.mojo_address),
                getString(R.string.mojo_hours),
                getString(R.string.mojo_contact),
                R.drawable.mojo));
        locations.add(new Location(getString(R.string.queens),
                getString(R.string.queens_desc),
                getString(R.string.queens_address),
                getString(R.string.queens_hours),
                getString(R.string.queens_contact),
                R.drawable.queens));
        locations.add(new Location(getString(R.string.craft_beer),
                getString(R.string.craft_beer_desc),
                getString(R.string.craft_beer_address),
                getString(R.string.craft_beer_hours),
                getString(R.string.craft_beer_contact),
                R.drawable.craft_beer));
        locations.add(new Location(getString(R.string.stpatrick),
                getString(R.string.stpatrick_desc),
                getString(R.string.stpatrick_address),
                getString(R.string.stpatrick_hours),
                getString(R.string.stpatrick_contact),
                R.drawable.stpatrick));
        locations.add(new Location(getString(R.string.drunken_lords),
                getString(R.string.drunken_lords_desc),
                getString(R.string.drunken_lords_address),
                getString(R.string.drunken_lords_hours),
                getString(R.string.drunken_lords_contact),
                R.drawable.drunken_lords));

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
