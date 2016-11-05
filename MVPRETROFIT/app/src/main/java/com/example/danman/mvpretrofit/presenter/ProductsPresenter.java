package com.example.danman.mvpretrofit.presenter;


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

    @Override
    public void loadProducts(String categoryName, int page) {

//        Call<Response<Product>> call = App.getApiManager().loadProducts(categoryName, page);
//        call.enqueue(new Callback<Response<Product>>() {
//            @Override
//            public void onResponse(retrofit2.Response<Response<Product>> response, Retrofit retrofit) {
//                List<Product> products = response.body().getResults();
//                mView.onProductsLoaded(products);
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                mView.onError(t.getMessage());
//            }
//        });
        App.getApiManager().loadProducts(categoryName, page).subscribe(new Subscriber<retrofit2.Response<Response<Product>>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(retrofit2.Response<Response<Product>> responseResponse) {
                mView.onProductsLoaded(responseResponse.body().getResults());
            }
        });

    }


    private void productsLoaded(List<Product> products) {
        mView.onProductsLoaded(products);
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
