package com.elfefe.exinterface.controller.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.elfefe.exinterface.controller.fragment.PageFragment;

public class PageAdapter extends FragmentPagerAdapter {

    private final int[] colors;

    public PageAdapter(FragmentManager fm, int[] colors) {
        super(fm);
        this.colors = colors;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position, this.colors[position]);
    }

    @Override
    public int getCount() {
        return 5;
    }
}
