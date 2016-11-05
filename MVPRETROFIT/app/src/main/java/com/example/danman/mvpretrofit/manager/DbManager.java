package com.example.danman.mvpretrofit.manager;


import android.util.Log;

import com.example.danman.mvpretrofit.model.Category;
import com.example.danman.mvpretrofit.model.Product;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;

/**
 * Created by DanMan on 26.10.2016.
 */
public class DbManager {
    private Realm realm;

    public DbManager() {
        realm = Realm.getDefaultInstance();
    }

    public void insertOrUpdateCategories(List<Category> categories) {
        try {
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(categories);
            realm.commitTransaction();
        } catch (RealmException ex) {
            realm.cancelTransaction();
            Log.e("realm", ex.getMessage());
        }
    }

    public void deleteCategories() {
        try {
            realm.beginTransaction();
            realm.where(Category.class).findAll().deleteAllFromRealm();
            realm.commitTransaction();
        } catch (RealmException ex) {
            realm.cancelTransaction();
            Log.e("realm", ex.getMessage());
        }
    }

    public List<Category> getCategories() {
        try {
            return realm.where(Category.class).findAll();
        } catch (RealmException ex) {
            realm.cancelTransaction();
            Log.e("realm", ex.getMessage());
        }
        return null;
    }

    public void addFavorites(List<Product> products) {
        try {
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(products);
            realm.commitTransaction();
        } catch (RealmException ex) {
            realm.cancelTransaction();
            Log.e("realm", ex.getMessage());
        }
    }

    public List<Product> getFavorites() {
        try {
            return realm.where(Product.class).findAll();
        } catch (RealmException ex) {
            realm.cancelTransaction();
            Log.e("realm", ex.getMessage());
        }
        return null;
    }
}
