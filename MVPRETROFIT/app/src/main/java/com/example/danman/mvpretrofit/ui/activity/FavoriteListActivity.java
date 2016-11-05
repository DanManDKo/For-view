package com.example.danman.mvpretrofit.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.danman.mvpretrofit.R;
import com.example.danman.mvpretrofit.contract.FavoritsContract;
import com.example.danman.mvpretrofit.model.Product;
import com.example.danman.mvpretrofit.presenter.FavoritesPresenter;
import com.example.danman.mvpretrofit.ui.adapter.ProductsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DanMan on 05.11.2016.
 */
public class FavoriteListActivity extends AppCompatActivity implements FavoritsContract.View, ProductsAdapter.OnProductClickCallBack {
    private RecyclerView mRecyclerView;
    private Toolbar mToolbar;
    private ProductsAdapter mAdapter;
    private List<Product> mProducts = new ArrayList<>();
    private FavoritesPresenter mFavoritesPresenter;
    private TextView mFavoritesAbsent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_list_activity);
        mFavoritesPresenter = new FavoritesPresenter();
        mFavoritesPresenter.attachView(this);
        initViews();
        mAdapter = new ProductsAdapter(mProducts);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void initViews() {
        initToolbar();
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_favorites);
        mFavoritesAbsent = (TextView) findViewById(R.id.tv_favorites_absent);
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.favorites_toolbar);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.favorites);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public void onFavoritesLoaded(List<Product> products) {
        mFavoritesAbsent.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
        mProducts.addAll(products);
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void onError(String message) {
        Log.e("error", message);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFavoritesPresenter.detachView();
    }

    @Override
    public void onItemClick(Product product) {
        Intent intent = new Intent(this, ProductInfoActivity.class);
        intent.putExtra("product", product);
        startActivity(intent);
    }
}
