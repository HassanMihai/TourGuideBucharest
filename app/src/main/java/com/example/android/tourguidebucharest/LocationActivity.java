package com.example.android.tourguidebucharest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LocationActivity extends AppCompatActivity {

    private final static int ICON_PADDING = 72;

    private ImageView locationImage;
    private TextView locationName;
    private TextView locationAddress;
    private String locationAddressMap;
    private TextView locationDescription;
    private TextView locationOpenHours;
    private TextView locationContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        locationImage = (ImageView) findViewById(R.id.image_view);
        locationName = (TextView) findViewById(R.id.location_name);
        locationDescription = (TextView) findViewById(R.id.location_description);
        locationOpenHours = (TextView) findViewById(R.id.location_open_hours);
        locationAddress = (TextView) findViewById(R.id.location_address);
        locationContact = (TextView) findViewById(R.id.location_contact);

        Intent selectedLocation = getIntent();
        Location location = selectedLocation.getParcelableExtra("LOCATION");
        int valueImageResourceId = location.getImageResourceId();
        String valueLocationName = location.getLocationName();
        String valueLocationDescription = location.getLocationDescription();
        String valueLocationAddress = location.getLocationAddress();
        String valueLocationOpenHours = location.getLocationOpenHours();
        String valueLocationContact = location.getLocationContact();

        this.setTitle(valueLocationName);

        locationImage.setImageResource(valueImageResourceId);

        locationName.setText(valueLocationName);

        locationDescription.setText(valueLocationDescription);
        locationDescription.setCompoundDrawablesWithIntrinsicBounds(R.drawable.info, 0,0,0);
        locationDescription.setCompoundDrawablePadding(ICON_PADDING);

        if (valueLocationOpenHours != null) {
            locationOpenHours.setText(valueLocationOpenHours);
            locationOpenHours.setCompoundDrawablesWithIntrinsicBounds(R.drawable.clock, 0,0,0);
            locationOpenHours.setCompoundDrawablePadding(ICON_PADDING);
        } else {
            locationOpenHours.setVisibility(View.GONE);
        }

        locationAddress.setText(valueLocationAddress);
        locationAddress.setCompoundDrawablesWithIntrinsicBounds(R.drawable.marker, 0,0,0);
        locationAddress.setCompoundDrawablePadding(ICON_PADDING);

        if (valueLocationContact != null) {
            locationContact.setText(valueLocationContact);
            locationContact.setCompoundDrawablesWithIntrinsicBounds(R.drawable.phone, 0,0,0);
            locationContact.setCompoundDrawablePadding(ICON_PADDING);
        } else {
            locationContact.setVisibility(View.GONE);
        }

        locationAddressMap = "geo:0,0?q=" + valueLocationAddress;

        // OnClickListener that open intent with location address in Google Maps
        locationAddress.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse(locationAddressMap);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
