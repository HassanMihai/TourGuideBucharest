package com.example.android.tourguidebucharest;

/**
 * Created by Miai on 4/11/2018.
 */

public class Location {

    private String mLocationName;

    private String mLocationDescription;

    private String mLocationAddress;

    private String mLocationOpenHours;

    private String mLocationContact;

    public Location(
            String locationName,
            String locationDescription,
            String locationAddress,
            String locationOpenHours,
            String locationContact
            ) {
        mLocationName = locationName;
        mLocationDescription = locationDescription;
        mLocationAddress = locationAddress;
        mLocationOpenHours = locationOpenHours;
        mLocationContact = locationContact;
    }

    /**
     * Get location name
     */
    public String getLocationName() {
        return mLocationName;
    }

    /**
     * Get location description
     */
    public String getLocationDescription() {
        return mLocationDescription;
    }

    /**
     * Get location address
     */
    public String getLocationAddress() {
        return mLocationAddress;
    }

    /**
     * Get location location open hours
     */
    public String getLocationOpenHours() {
        return mLocationOpenHours;
    }

    /**
     * Get location location contact
     */
    public String getLocationContact() {
        return mLocationContact;
    }

}
