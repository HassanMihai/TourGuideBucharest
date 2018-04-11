package com.example.android.tourguidebucharest;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Miai on 4/11/2018.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MuseumsFragment();
        } else if (position == 1) {
            return new ParksFragment();
        } else if (position == 2) {
            return new FoodFragment();
        } else {
            return new NightLifeFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Museums";
        } else if (position == 1) {
            return "Parks";
        } else if (position == 2) {
            return "Food";
        } else {
            return "Night Life";
        }
    }

}
