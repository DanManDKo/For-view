package com.example.danman.mvpretrofit.presenter;

import com.example.danman.mvpretrofit.App;
import com.example.danman.mvpretrofit.contract.FavoritsContract;

/**
 * Created by DanMan on 05.11.2016.
 */
public class FavoritesPresenter implements FavoritsContract.presentor {
    private FavoritsContract.View mView;

    public void loadFavorites(String categoryName, int page) {
        mView.onFavoritesLoaded(App.getFavoritesManager().getFavorites());
    }

    @Override
    public void attachView(FavoritsContract.View view) {
        mView = view;

    }

    @Override
    public void detachView() {
        mView = null;
    }
}
