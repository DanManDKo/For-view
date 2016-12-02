package com.example.danman.mvpretrofit.presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.util.Log;

import com.example.danman.mvpretrofit.App;
import com.example.danman.mvpretrofit.R;
import com.example.danman.mvpretrofit.contract.CategoriesContract;
import com.example.danman.mvpretrofit.manager.DbManager;
import com.example.danman.mvpretrofit.model.Category;
import com.example.danman.mvpretrofit.model.Response;
import com.example.danman.mvpretrofit.ui.activity.CategoriesListActivity;


import java.util.List;

import rx.Subscriber;

/**
 * Created by DanMan on 11.10.2016.
 */
public class CategoriesPresenter implements CategoriesContract.presenter {
    private CategoriesContract.View mView;
    private DbManager mDbManager = App.getDbManager();
    private final String TAG = "presenter";
    public void loadCategoriesFromNetwork() {
        App.getApiManager().loadCategories().subscribe(new Subscriber<retrofit2.Response<Response<Category>>>() {
            @Override
            public void onCompleted() {
            }
            @Override
            public void onError(Throwable e) {
                Log.e(TAG, e.getMessage());
            }
            @Override
            public void onNext(retrofit2.Response<Response<Category>> responseResponse) {
                List<Category> categories = responseResponse.body().getResults();
                mDbManager.insertOrUpdateCategories(categories);
                mView.onCategoriesLoaded(categories);
            }
        });
    }

    @Override
    public void loadCategoriesFromDB() {
        mView.onCategoriesLoaded(mDbManager.getCategories());
    }

    @Override
    public void saveCategoriesToDB(List<Category> categories) {
        mDbManager.insertOrUpdateCategories(categories);
    }

    @Override
    public boolean isOnline() {
        ConnectivityManager manager = (ConnectivityManager) mView.getContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        }
        return isAvailable;
    }


    @Override
    public void attachView(CategoriesContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

}
