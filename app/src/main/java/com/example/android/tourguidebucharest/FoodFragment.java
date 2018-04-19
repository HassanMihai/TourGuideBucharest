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
public class FoodFragment extends Fragment {

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);


        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.caru_cu_bere),
                getString(R.string.caru_cu_bere_desc),
                getString(R.string.caru_cu_bere_address),
                getString(R.string.caru_cu_bere_hours),
                getString(R.string.caru_cu_bere_contact),
                R.drawable.caru_cu_bere));
        locations.add(new Location(getString(R.string.mesogios),
                getString(R.string.mesogios_desc),
                getString(R.string.mesogios_address),
                getString(R.string.mesogios_hours),
                getString(R.string.mesogios_contact),
                R.drawable.mesogios));
        locations.add(new Location(getString(R.string.casa_doina),
                getString(R.string.casa_doina_desc),
                getString(R.string.casa_doina_address),
                getString(R.string.casa_doina_hours),
                getString(R.string.casa_doina_contact),
                R.drawable.casa_doina));
        locations.add(new Location(getString(R.string.excalibur),
                getString(R.string.excalibur_desc),
                getString(R.string.excalibur_address),
                getString(R.string.excalibur_hours),
                getString(R.string.excalibur_contact),
                R.drawable.excalibur));

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
