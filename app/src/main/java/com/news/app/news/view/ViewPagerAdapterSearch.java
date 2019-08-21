package com.news.app.news.view;

/**
 * Created by USER on 4/29/2019.
 */

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public class ViewPagerAdapterSearch extends FragmentPagerAdapter {

    private static final String TAG = "";
    private String title[] = {"SEARCH RESULTS"};
    Intent intent ;
    public ViewPagerAdapterSearch(FragmentManager manager, Intent intent) {
        super(manager);

        this.intent= intent ;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                return new SearchFragment(intent);
            default:
                return new TopFragment();

        }
    }


    @Override
    public int getCount() {
        return title.length;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}

