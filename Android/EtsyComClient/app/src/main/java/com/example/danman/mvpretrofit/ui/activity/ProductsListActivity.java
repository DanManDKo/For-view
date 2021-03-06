package com.example.danman.mvpretrofit.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.danman.mvpretrofit.R;
import com.example.danman.mvpretrofit.contract.ProductsContract;
import com.example.danman.mvpretrofit.ui.adapter.listener.EndlessRecyclerViewScrollListener;
import com.example.danman.mvpretrofit.model.Product;
import com.example.danman.mvpretrofit.presenter.ProductsPresenter;
import com.example.danman.mvpretrofit.ui.adapter.ProductsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DanMan on 13.10.2016.
 */
public class ProductsListActivity extends AppCompatActivity implements ProductsContract.View, ProductsAdapter.OnProductClickCallBack {
    private ProductsPresenter mProductsPresenter;
    private RecyclerView mRecyclerView;
    private List<Product> mProducts = new ArrayList<>();
    private ProductsAdapter adapter;
    private Toolbar mToolbar;
    private ProgressBar mProgressBar;
    private final String NAME_EXTRA_KEY = "name";
    private final String PRODUCT_EXTRA_KEY = "product";
    private final String TAG = "products";
    private final int FIRST_PAGE = 1;
    private String mName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list_activity);
        mName = getIntent().getStringExtra(NAME_EXTRA_KEY);
        initViews();
        adapter = new ProductsAdapter(mProducts);
        adapter.setOnItemClick(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                Snackbar snackbar = Snackbar.make(findViewById(R.id.product_list_activity_layout), R.string.loading, Snackbar.LENGTH_SHORT);
                snackbar.show();
                mProductsPresenter.loadProducts(mName, page);
            }
        });
        mProductsPresenter = new ProductsPresenter();
        mProductsPresenter.attachView(this);
        mProductsPresenter.loadProducts(mName, FIRST_PAGE);
    }

    private void initViews() {
        initToolbar();
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_products);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar_product);
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.product_list_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(R.string.products);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mProductsPresenter.detachView();
    }

    @Override
    public void onProductsLoaded(List<Product> products) {
        mProgressBar.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
        mProducts.addAll(products);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String message) {
        Log.e(TAG, message);
    }

    @Override
    public void onItemClick(Product product) {
        Intent intent = new Intent(this, ProductInfoActivity.class);
        intent.putExtra(PRODUCT_EXTRA_KEY, product);
        startActivity(intent);
    }


}
