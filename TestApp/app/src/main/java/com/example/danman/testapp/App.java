package com.example.danman.testapp;

import android.app.Application;

import com.example.danman.testapp.manager.ContentManager;
import com.example.danman.testapp.manager.SearchManager;

/**
 * Created by DanMan on 13.12.2016.
 */
public class App extends Application {
    private static ContentManager sContentManager;
    private static SearchManager sSearchManager;

    public static ContentManager getContentManager() {
        if (sContentManager == null)
            sContentManager = new ContentManager();
        return sContentManager;
    }

    public static SearchManager getSearchManager() {
        if (sSearchManager == null)
            sSearchManager = new SearchManager();
        return sSearchManager;
    }
}
