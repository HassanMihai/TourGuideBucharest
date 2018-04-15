package com.example.android.tourguidebucharest;

import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable {

    private String mLocationName;

    private String mLocationDescription;

    private String mLocationAddress;

    private String mLocationOpenHours;

    private String mLocationContact;

    /** Image resource ID for the words */
    private int mImageResourceId;

    public Location(
            String locationName,
            String locationDescription,
            String locationAddress,
            String locationOpenHours,
            String locationContact,
            int locationImageResourceId
            ) {
        mLocationName = locationName;
        mLocationDescription = locationDescription;
        mLocationAddress = locationAddress;
        mLocationOpenHours = locationOpenHours;
        mLocationContact = locationContact;
        mImageResourceId = locationImageResourceId;
    }

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

    public Location(
            String locationName,
            String locationDescription,
            String locationAddress,
            int locationImageResourceId
    ) {
        mLocationName = locationName;
        mLocationDescription = locationDescription;
        mLocationAddress = locationAddress;
        mImageResourceId = locationImageResourceId;
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
     * Get location open hours
     */
    public String getLocationOpenHours() {
        return mLocationOpenHours;
    }

    /**
     * Get location contact
     */
    public String getLocationContact() {
        return mLocationContact;
    }

    /**
     * Get location image resource id
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    //write object values to parcel for storage
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(mLocationName);
        dest.writeString(mLocationDescription);
        dest.writeString(mLocationAddress);
        dest.writeString(mLocationOpenHours);
        dest.writeString(mLocationContact);
        dest.writeInt(mImageResourceId);
    }

    //constructor used for parcel
    public Location(Parcel parcel){
        mLocationName = parcel.readString();
        mLocationDescription = parcel.readString();
        mLocationAddress = parcel.readString();
        mLocationOpenHours = parcel.readString();
        mLocationContact = parcel.readString();
        mImageResourceId = parcel.readInt();
    }

    //creator - used when un-parceling our parcle (creating the object)
    public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>(){

        @Override
        public Location createFromParcel(Parcel parcel) {
            return new Location(parcel);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[0];
        }
    };

    //return hashcode of object
    public int describeContents() {
        return hashCode();
    }

}
