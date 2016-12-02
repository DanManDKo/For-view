package com.example.danman.mvpretrofit.presenter;

import com.example.danman.mvpretrofit.App;
import com.example.danman.mvpretrofit.contract.FavoritesContract;
import com.example.danman.mvpretrofit.contract.ProductsContract;
import com.example.danman.mvpretrofit.model.Product;

import java.util.List;

/**
 * Created by DanMan on 05.11.2016.
 */
public class FavoritesPresenter implements FavoritesContract.presenter {
    private FavoritesContract.View mView;

    @Override
    public void loadProducts() {
        List<Product> favorites = App.getDbManager().getFavorites();
            mView.onProductsLoaded(favorites);
    }

    @Override
    public void attachView(FavoritesContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
