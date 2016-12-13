package com.example.danman.testapp.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.danman.testapp.ui.fragment.PageFragment;

import java.util.List;


/**
 * Created by DanMan on 12.12.2016.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<PageFragment> mFragments;

    public ViewPagerAdapter(FragmentManager fragmentManager, @NonNull List<PageFragment> fragments) {
        super(fragmentManager);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
