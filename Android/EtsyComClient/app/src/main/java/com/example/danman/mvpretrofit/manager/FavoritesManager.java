package com.example.danman.mvpretrofit.manager;

import com.example.danman.mvpretrofit.App;
import com.example.danman.mvpretrofit.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DanMan on 05.11.2016.
 */
public class FavoritesManager {
    private List<Product> mFavorites;
    private DbManager mDbManager;

    public FavoritesManager() {
        mDbManager = App.getDbManager();
        mFavorites = new ArrayList<>();
        mFavorites.addAll(mDbManager.getFavorites());

    }

    public void addFavorite(Product product) {
        mFavorites.add(product);
    }

    public boolean removeFavorite(Product product) {
        if (isFavorite(product)) {
            mFavorites.remove(product);
            mDbManager.removeFavorite(product);
            return true;
        }
        return false;
    }

    public List<Product> getFavorites() {
        return mFavorites;
    }

    public void save() {
        if (!mFavorites.isEmpty())
            mDbManager.addFavorites(mFavorites);
    }

    public boolean isFavorite(Product product) {
        if (mFavorites.isEmpty())
            return false;
        return mFavorites.contains(product);
    }



}
