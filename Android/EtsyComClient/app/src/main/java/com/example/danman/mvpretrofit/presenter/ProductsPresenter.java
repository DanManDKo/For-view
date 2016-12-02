package com.example.danman.mvpretrofit.presenter;


import android.util.Log;

import com.example.danman.mvpretrofit.App;
import com.example.danman.mvpretrofit.contract.ProductsContract;
import com.example.danman.mvpretrofit.model.Product;
import com.example.danman.mvpretrofit.model.Response;

import java.util.List;

import rx.Subscriber;


/**
 * Created by DanMan on 13.10.2016.
 */
public class ProductsPresenter implements ProductsContract.presenter {
    private ProductsContract.View mView;
    private final String TAG = "Api";

    @Override
    public void loadProducts(String categoryName, int page) {

        App.getApiManager().loadProducts(categoryName, page).subscribe(new Subscriber<retrofit2.Response<Response<Product>>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, e.getMessage());
            }

            @Override
            public void onNext(retrofit2.Response<Response<Product>> responseResponse) {
                mView.onProductsLoaded(responseResponse.body().getResults());
            }
        });
    }

    @Override
    public void attachView(ProductsContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
