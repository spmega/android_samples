package com.example.android.horizontalpaging;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by shashank on 5/21/16.
 */
public class MyAdapter extends FragmentPagerAdapter {

    static final int NUM_ITEMS = 2;

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0)
            return ArrayListFragment.newInstance(position);
        else
            return MyFragment.newInstance(1);
    }
}
