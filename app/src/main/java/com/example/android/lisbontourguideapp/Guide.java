package com.example.android.lisbontourguideapp;

/**
 * {@link Guide} represents interesting place for a lisbon guide.
 * It contains the name, typical neighboard, and a representing image.
 */
public class Guide {

    /** String resource ID for the place of the guide */
    private int mPlaceId;

    /** String resource ID for the eighborhoodId of the guide */
    private int mNeighborhoodId;


    /** Image resource ID for the place */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this guide */
    private static final int NO_IMAGE_PROVIDED = -1;



    /**
     * Create a new Guide object.
     *
     * @param PlaceId is the string resource ID for place to be show the guide
     * @param NeighborhoodId is the string resource Id for the neighborhood of the place
     * @param imageResourceId is the drawable resource ID for the image associated with the guide
     */
    public Guide(int PlaceId, int NeighborhoodId, int imageResourceId) {
        mPlaceId = PlaceId;
        mNeighborhoodId = NeighborhoodId;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the string resource ID for the default translation of the guide.
     */
    public int getPlaceId() {
        return mPlaceId;
    }

    /**
     * Get the string resource ID for the Miwok translation of the guide.
     */
    public int getNeighborhoodId() {
        return mNeighborhoodId;
    }

    /**
     * Return the image resource ID of the guide.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this guide.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }


}
