package com.example.danman.mvpretrofit.ui.activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.danman.mvpretrofit.R;
import com.example.danman.mvpretrofit.contract.CategoriesContract;
import com.example.danman.mvpretrofit.model.Category;
import com.example.danman.mvpretrofit.presenter.CategoriesPresenter;
import com.example.danman.mvpretrofit.ui.adapter.CategoriesAdapter;

import java.util.List;

import io.realm.Realm;

public class CategoriesListActivity extends AppCompatActivity implements CategoriesContract.iView, CategoriesAdapter.OnCategoryClickCallBack {
    private RecyclerView mRecyclerView;
    private CategoriesPresenter mCategoriesPresenter;
    private Toolbar mToolbar;
    private List<Category> mCategories;
    private ProgressBar mProgressBar;
    private RelativeLayout mRelativeLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_list_activity);
        initViews();
        Realm.init(this);
        mCategoriesPresenter = new CategoriesPresenter();
        mCategoriesPresenter.attachView(this);
        loadData();
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(R.string.categories);
    }

    private void initViews() {
        initToolbar();
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relative_layout_categories);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_categories);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar_category);
    }


    @Override
    public void onCategoriesLoaded(List<Category> categories) {
        this.mCategories = categories;
        mProgressBar.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(categories);
        categoriesAdapter.setOnItemClick(this);
        mRecyclerView.setAdapter(categoriesAdapter);
    }

    private void loadData() {
        if (mCategoriesPresenter.isOnline()) {
            mCategoriesPresenter.loadCategoriesFromNetwork();
            mCategoriesPresenter.saveCategoriesToDB(mCategories);
        } else {
            mCategoriesPresenter.loadCategoriesFromDB();
            Snackbar.make(mRelativeLayout, R.string.network_troubles, Snackbar.LENGTH_INDEFINITE)
                    .setAction(R.string.refresh, new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    loadData();
                                }
                            }
                    ).show();
        }
    }


    @Override
    public void onError(String message) {
        Log.e("error", message);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCategoriesPresenter.detachView();
    }

    @Override
    public void onItemClick(Category category) {
        Intent intent = new Intent(this, ProductsListActivity.class);
        intent.putExtra("name", category.getName());
        startActivity(intent);
    }
}