package com.example.android.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Harshit on 26-01-2018.
 */

public class CustomFragmentPagerAdapter  extends FragmentPagerAdapter {
    private Context mContext = null;

    @Override
    public int getCount() {
        return 4;
    }

    public CustomFragmentPagerAdapter(Context context, FragmentManager fm)
    {
        super(fm);
        mContext = context;
    }



    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Top_Attraction_Fragment();
            case 1:
                return new Restaurants_Fragment();
            case 2:
                return new Hotels_Fragment();
            case 3:
                return new Temples_Fragment();
            default:
                return null;
        }

    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.category_top_attraction).toUpperCase();
            case 1:
                return mContext.getString(R.string.category_restaurants).toUpperCase();
            case 2:
                return mContext.getString(R.string.category_hotels).toUpperCase();
            case 3:
                return mContext.getString(R.string.category_temples).toUpperCase();
            default:
                return null;
        }

    }

}
