package com.example.danman.mvpretrofit.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.danman.mvpretrofit.App;
import com.example.danman.mvpretrofit.R;
import com.example.danman.mvpretrofit.contract.ProductsContract;
import com.example.danman.mvpretrofit.model.Product;
import com.example.danman.mvpretrofit.presenter.FavoritesPresenter;
import com.example.danman.mvpretrofit.presenter.ProductsPresenter;
import com.example.danman.mvpretrofit.ui.adapter.ProductsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DanMan on 05.11.2016.
 */
public class FavoriteListActivity extends AppCompatActivity implements ProductsContract.View, ProductsAdapter.OnProductClickCallBack {
    private RecyclerView mRecyclerView;
    private Toolbar mToolbar;
    private ProductsAdapter mAdapter;
    private List<Product> mProducts = new ArrayList<>();
    private FavoritesPresenter mFavoritesPresenter;
    private TextView mFavoritesAbsent;
    private ActionBarDrawerToggle mToggle;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_list_activity);
        mFavoritesPresenter = new FavoritesPresenter();
        mFavoritesPresenter.attachView(this);
        initViews();
        mAdapter = new ProductsAdapter(mProducts);
        mAdapter.setOnItemClick(this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onResume() {
        super.onResume();

            mNavigationView.setCheckedItem(R.id.favorites_item_menu);
            mFavoritesPresenter.loadProducts();
            mAdapter.notifyDataSetChanged();

    }

    private void initViews() {
        initToolbar();
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_favorites);
        mFavoritesAbsent = (TextView) findViewById(R.id.tv_favorites_absent);
        initDrawer();
    }

    private void initDrawer() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.favorites_drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.favorites_navigation_view);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.categories_item_menu) {
                    Intent intent = new Intent(FavoriteListActivity.this, CategoriesListActivity.class);
                    mDrawerLayout.closeDrawer(mNavigationView);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);

        mToggle.syncState();
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.favorites_toolbar);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.favorites);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }


    @Override
    public void onProductsLoaded(List<Product> products) {
        if(!products.isEmpty()) {
            mFavoritesAbsent.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
            mProducts.addAll(products);
            mAdapter.notifyDataSetChanged();
        }else {
            mFavoritesAbsent.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
        }


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
