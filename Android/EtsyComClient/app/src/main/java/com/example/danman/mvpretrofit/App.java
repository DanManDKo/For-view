package com.example.danman.mvpretrofit;

import android.app.Application;

import com.example.danman.mvpretrofit.manager.ApiManager;
import com.example.danman.mvpretrofit.manager.DbManager;
import com.example.danman.mvpretrofit.manager.FavoritesManager;

/**
 * Created by DanMan on 10.10.2016.
 */
public class App extends Application {
    private static ApiManager sApiManager;
    private static DbManager sDbManager;
    private static FavoritesManager sFavoritesManager;
    public static ApiManager getApiManager() {
        if (sApiManager == null) {
            sApiManager = new ApiManager();
            sApiManager.init();
        }
        return sApiManager;
    }

    public static DbManager getDbManager() {
        if (sDbManager == null) {
            sDbManager = new DbManager();
        }
        return sDbManager;
    }
    public static FavoritesManager getFavoritesManager(){
        if (sFavoritesManager==null){
            sFavoritesManager=new FavoritesManager();
        }
        return sFavoritesManager;
    }

}
