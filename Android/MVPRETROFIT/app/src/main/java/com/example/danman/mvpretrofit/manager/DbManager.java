package com.example.danman.mvpretrofit.manager;


import android.util.Log;

import com.example.danman.mvpretrofit.model.Category;
import com.example.danman.mvpretrofit.model.Product;

import java.util.Iterator;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;

/**
 * Created by DanMan on 26.10.2016.
 */
public class DbManager {
    private final String PRODUCT_ID = "productId";
    private Realm realm;
    private final String TAG = "realm";

    public DbManager() {
        realm = Realm.getDefaultInstance();
    }

    public void insertOrUpdateCategories(List<Category> categories) {
        try {
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(categories);
            realm.commitTransaction();
        } catch (Exception ex) {
            realm.cancelTransaction();
            Log.e(TAG, ex.getMessage());
        }
    }

    public List<Category> getCategories() {
        return realm.where(Category.class).findAll();
    }

    public void addFavorites(List<Product> products) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(products);
        realm.commitTransaction();
    }

    public List<Product> getFavorites() {
        return realm.where(Product.class).findAll();
    }

    public boolean removeFavorite(Product product) {
        try {
            RealmResults<Product> products = realm.where(Product.class)
                    .beginGroup()
                    .equalTo(PRODUCT_ID, product.getProductId())
                    .endGroup().findAll();
            realm.beginTransaction();
            products.deleteAllFromRealm();
            realm.commitTransaction();
            return true;
        } catch (Exception ex) {
            realm.cancelTransaction();
            Log.e(TAG, ex.getMessage());
        }
        return false;
    }
}




