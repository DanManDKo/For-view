package com.example.danman.mvpretrofit.presenter;

import com.example.danman.mvpretrofit.App;
import com.example.danman.mvpretrofit.contract.ProductsContract;
import com.example.danman.mvpretrofit.model.Product;

import java.util.List;

/**
 * Created by DanMan on 05.11.2016.
 */
public class FavoritesPresenter implements ProductsContract.presenter {
    private ProductsContract.View mView;


    @Override
    public void loadProducts(String categoryName, int page) {
    }


    @Override
    public void loadProducts() {
        List<Product> favorites = App.getDbManager().getFavorites();
            mView.onProductsLoaded(favorites);
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
