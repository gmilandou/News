package com.news.app.news.view;

/**
 * Created by USER on 4/29/2019.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private static final String TAG = "";
    private String title[] = {"TOP STORIES", "MOST POPULAR", "BUSINESS"};

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        Log.d(TAG, "get my position: " + position);
        switch (position){

            case 0 :
                return new TopFragment() ;
            case 1 :
                return new MostFragment() ;
            case 2:
                //return new MostFragment() ;
                return new ArticleFragment() ;
                default:
                return new TopFragment() ;

        }
       // return TabFragment.getInstance(position);

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

