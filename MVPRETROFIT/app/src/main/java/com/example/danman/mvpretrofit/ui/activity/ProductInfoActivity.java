package com.example.danman.mvpretrofit.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.net.ParseException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.example.danman.mvpretrofit.App;
import com.example.danman.mvpretrofit.R;
import com.example.danman.mvpretrofit.manager.FavoritesManager;
import com.example.danman.mvpretrofit.model.Image;
import com.example.danman.mvpretrofit.model.Product;
import com.example.danman.mvpretrofit.ui.adapter.ImageAdapter;
import com.viewpagerindicator.CirclePageIndicator;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by DanMan on 18.10.2016.
 */
public class ProductInfoActivity extends AppCompatActivity implements ImageAdapter.OnItemClickCallBack {
    private Toolbar mToolbar;
    private Product mProduct;
    private ViewPager mViewPager;
    private TextView mTitle;
    private TextView mDescription;
    private TextView mPrice;
    private TextView mCurrencyCode;
    private ImageAdapter mImageAdapter;
    private int mColorOfToolbar;
    private CirclePageIndicator mCirclePageIndicator;
    private FavoritesManager mFavoritesManager;
    private ImageView mFavoriteImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_info_activity);
        mProduct = getIntent().getParcelableExtra("product");
        initViews();
        mFavoritesManager = App.getFavoritesManager();
        if (mFavoritesManager.isFavorite(mProduct)) {
            mFavoriteImageView.setImageResource(R.drawable.ic_favorite);
        }
        mFavoriteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFavoritesManager.isFavorite(mProduct)) {
                    mFavoritesManager.removeFavorite(mProduct);
                    mFavoriteImageView.setImageResource(R.drawable.ic_not_favorite);
                } else {
                    mFavoritesManager.addFavorite(mProduct);
                    mFavoriteImageView.setImageResource(R.drawable.ic_favorite);
                }
            }
        });
        mTitle.setText(mProduct.getTitle());
        mPrice.setText(mProduct.getPrice());
        mCurrencyCode.setText(mProduct.getCurrencyCode());
        mDescription.setText(mProduct.getDescription());
        mViewPager.setOffscreenPageLimit(1);
        mImageAdapter = new ImageAdapter();
        mImageAdapter.setItem(R.layout.item_view_pager_center_crop);
        mImageAdapter.addViews(mProduct.getImages());
        mImageAdapter.setOnItemClickCallBack(this);
        mViewPager.setAdapter(mImageAdapter);
        mCirclePageIndicator.setViewPager(mViewPager);

    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.full_product_toolbar);
        Image image;
        if (mProduct != null && !mProduct.getImages().isEmpty()) {
            try {
                image = mProduct.getImages().get(0);
                mColorOfToolbar = Color.rgb(
                        Integer.parseInt(image.getRed()),
                        Integer.parseInt(image.getGreen()),
                        Integer.parseInt(image.getBlue()));
                mToolbar.setBackgroundColor(mColorOfToolbar);
            } catch (ParseException ex) {
                Log.e("toolbarEX", ex.getMessage());
            }
        }
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.info);
    }

    private void initViews() {
        initToolbar();
        mFavoriteImageView = (ImageView) findViewById(R.id.iv_favorite);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mTitle = (TextView) findViewById(R.id.tv_title);
        mPrice = (TextView) findViewById(R.id.tv_price);
        mCurrencyCode = (TextView) findViewById(R.id.tv_currency_code);
        mDescription = (TextView) findViewById(R.id.tv_description);
        mCirclePageIndicator = (CirclePageIndicator) findViewById(R.id.circle_page_indicator);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (android.R.id.home):
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick() {
        Intent intent = new Intent(ProductInfoActivity.this, GalleryActivity.class);
        intent.putExtra("product", mProduct);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mFavoritesManager.save();
    }
}
