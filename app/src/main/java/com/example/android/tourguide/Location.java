package com.example.android.tourguide;

/**
 * Created by Harshit on 27-01-2018.
 */

public class Location {

    /**
     * variable to store location name
     */
    private String mlocationName;

    /**
     * variable to store location description
     */
    private String mlocationDescription;

    /**
     * variable to store Resource id of image
     */
    private int mImageResourceId;

    public Location(String mlocationName, String mlocationDescription, int mImageResourceId) {
        this.mlocationName = mlocationName;
        this.mlocationDescription = mlocationDescription;
        this.mImageResourceId = mImageResourceId;
    }

    public String getMlocationName() {
        return mlocationName;
    }

    public String getMlocationDescription() {
        return mlocationDescription;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }
}

