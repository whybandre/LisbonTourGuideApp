package com.example.android.lisbontourguideapp;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link GuideAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Guide} objects.
 */
public class GuideAdapter extends ArrayAdapter<Guide> {


    /** Resource ID for the background color for this list of guides */
    private int mImageResourceId;

    /**
     * Create a new {@link GuideAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param places is the list of {@link Guide}s to be displayed.
     * @param imageResourceId is the resource ID for the background color for this list of guides
     */
    public GuideAdapter(Context context, ArrayList<Guide> places, int imageResourceId) {
        super(context, 0, places);
        mImageResourceId = imageResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Guide} object located at this position in the list
        Guide currentPlace = getItem(position);

        // Find the TextView in the list_item.xml layout
        TextView neighborhoodTextView = (TextView) listItemView.findViewById(R.id.neighborhood_text_view);
        // Get the Neighborhood from the currentPlace object and set this text on
        // the Neighborhood TextView.
        neighborhoodTextView.setText(currentPlace.getNeighborhoodId());

        // Find the TextView in the list_item.xml layout
        TextView placeTextView = (TextView) listItemView.findViewById(R.id.place_text_view);
        // Get the place from the currentPlace object and set this text on
        // the place TextView.
        placeTextView.setText(currentPlace.getPlaceId());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this guide or not
        if (currentPlace.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentPlace.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mImageResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }



}
