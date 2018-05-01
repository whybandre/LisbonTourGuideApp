package com.example.android.lisbontourguideapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;



    /**
     * {@link TypeAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
     * each list item based on a data source which is a list of {@link Guide} objects.
     */
    public class TypeAdapter extends FragmentPagerAdapter {

        /** Context of the app */
        private Context mContext;

        /**
         * Create a new {@link TypeAdapter} object.
         *
         * @param context is the context of the app
         * @param fm is the fragment manager that will keep each fragment's state in the adapter
         *           across swipes.
         */
        public TypeAdapter(Context context, FragmentManager fm) {
            super(fm);
            mContext = context;
        }

        /**
         * Return the {@link Fragment} that should be displayed for the given page number.
         */
        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new ParkFragment();
            } else if (position == 1) {
                return new ArtFragment();
            } else if (position == 2) {
                return new EatFragment();
            } else {
                return new DrinkFragment();
            }
        }

        /**
         * Return the total number of pages.
         */
        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0) {
                return mContext.getString(R.string.menu_park);
            } else if (position == 1) {
                return mContext.getString(R.string.menu_culture);
            } else if (position == 2) {
                return mContext.getString(R.string.menu_eat);
            } else {
                return mContext.getString(R.string.menu_drink   );
            }
        }
    }

