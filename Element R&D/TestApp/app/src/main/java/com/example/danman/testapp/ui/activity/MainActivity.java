package com.example.danman.testapp.ui.activity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.danman.testapp.App;
import com.example.danman.testapp.R;
import com.example.danman.testapp.manager.ContentManager;
import com.example.danman.testapp.manager.SearchManager;
import com.example.danman.testapp.ui.adapter.ViewPagerAdapter;
import com.example.danman.testapp.ui.fragment.PageFragment;
import com.example.danman.testapp.model.SomeModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    private ContentManager mContentManager;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mToggle;
    private final int FIRST_CARD = 0;
    private final int SECOND_CARD = 1;
    private List<PageFragment> mFragments;
    private SearchManager mSearchManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContentManager = App.getContentManager();
        mSearchManager = App.getSearchManager();
        initView();
    }

    private void initView() {
        initFragments();
        initViewPager();
        initDrawer();
        initToolbar();
    }

    private void initDrawer() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setCheckedItem(R.id.first_item);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.first_item) {
                    mNavigationView.setCheckedItem(R.id.first_item);
                    mViewPager.setCurrentItem(FIRST_CARD);
                    mDrawerLayout.closeDrawers();
                } else if (item.getItemId() == R.id.second_item) {
                    mNavigationView.setCheckedItem(R.id.second_item);
                    mViewPager.setCurrentItem(SECOND_CARD);
                    mDrawerLayout.closeDrawers();
                }
                return false;
            }
        });
        mToggle.syncState();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_main);
        mToolbar.setTitle(R.string.app_name);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.titleColor));
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        mFragments.add(PageFragment.newInstance((ArrayList<SomeModel>) mContentManager.getDataForFirst()));
        mFragments.add(PageFragment.newInstance((ArrayList<SomeModel>) mContentManager.getDataForSecond()));
        mSearchManager.setListeners(mFragments);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mToggle.syncState();
    }

    private void initViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager_main);
        mViewPager.setClipToPadding(false);
        mViewPager.setPadding(125, 0, 125, 0);
        mViewPager.setPageMargin(25);
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == FIRST_CARD) {
                    mNavigationView.setCheckedItem(R.id.first_item);
                } else if (position == SECOND_CARD) {
                    mNavigationView.setCheckedItem(R.id.second_item);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.search_action);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        mSearchManager.sendQuery(mViewPager.getCurrentItem(), query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        return false;
    }

    public interface OnTextChangedCallback {
        void onTextChange(String query);
    }
}
