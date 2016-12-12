package com.example.danman.elementrd.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.danman.elementrd.R;
import com.example.danman.elementrd.ui.fragment.PageFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private List<Fragment> mFragments;
    private Fragment mFragmentFirst;
    private Fragment mFragmentSecond;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        initToolbar();
        initFragments();
        initPager();

    }
    private void initFragments() {
        mFragmentFirst = new PageFragment();
        mFragmentSecond = new PageFragment();
        mFragments = new ArrayList<>();
        mFragments.add(mFragmentFirst);
        mFragments.add(mFragmentSecond);
    }

    private void initPager() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager_main);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout_main);
        mTabLayout.setupWithViewPager(mViewPager);
    }



    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_main);
        mToolbar.setTitle(R.string.app_name);
        mToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.titleColor));
        setSupportActionBar(mToolbar);
    }


}
