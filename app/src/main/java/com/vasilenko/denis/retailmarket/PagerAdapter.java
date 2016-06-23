package com.vasilenko.denis.retailmarket;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by vasilenkoden on 23.06.2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter{
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position){
            case 0:
                frag=new Fragment1();
                break;
            case 1:
                frag=new Fragment2();
                break;
            case 2:
                frag=new Fragment3();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        String title=" ";
        switch (position){
            case 0:
                title="First";
                break;
            case 1:
                title="Second";
                break;
            case 2:
                title="Third";
                break;
        }

        return title;
    }
}
