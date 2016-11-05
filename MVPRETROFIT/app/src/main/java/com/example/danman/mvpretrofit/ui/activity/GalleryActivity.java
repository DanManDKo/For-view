package com.example.danman.mvpretrofit.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.danman.mvpretrofit.R;
import com.example.danman.mvpretrofit.model.Product;
import com.example.danman.mvpretrofit.ui.adapter.ImageAdapter;

/**
 * Created by DanMan on 04.11.2016.
 */
public class GalleryActivity extends AppCompatActivity {
    private Product mProduct;
    private ViewPager mViewPager;
    private ImageAdapter mImageAdapter;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_activity);
        mProduct = getIntent().getParcelableExtra("product");
        initViews();
        mViewPager.setOffscreenPageLimit(1);
        mImageAdapter = new ImageAdapter();
        mImageAdapter.setItem(R.layout.item_view_pager_fit_center);
        mImageAdapter.addViews(mProduct.getImages());
        mViewPager.setAdapter(mImageAdapter);

    }

    private void initViews() {
        initToolbar();
        mViewPager = (ViewPager) findViewById(R.id.pager_gallery);

    }
    private void initToolbar(){
        mToolbar = (Toolbar) findViewById(R.id.gallery_toolbar);
        mToolbar.setBackgroundColor(Color.BLACK);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(R.string.gallery);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (android.R.id.home):
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
