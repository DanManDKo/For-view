package com.example.danman.testapp;

import android.app.Application;

import com.example.danman.testapp.manager.ContentManager;

/**
 * Created by DanMan on 13.12.2016.
 */
public class App extends Application {
    private static ContentManager sContentManager;

    public static ContentManager getContentManager() {
        if (sContentManager == null)
            sContentManager = new ContentManager();
        return sContentManager;
    }
}
