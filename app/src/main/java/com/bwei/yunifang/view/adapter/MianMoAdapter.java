package com.bwei.yunifang.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Mayuefeng on 2016/12/15.
 */
public class MianMoAdapter extends FragmentPagerAdapter{
    ArrayList<Fragment> fragments;

    public MianMoAdapter(FragmentManager fm,  ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
