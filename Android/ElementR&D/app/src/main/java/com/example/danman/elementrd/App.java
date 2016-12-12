package com.example.danman.elementrd;

import android.app.Application;

import com.example.danman.elementrd.manager.ContentManager;

/**
 * Created by DanMan on 11.12.2016.
 */
public class App extends Application {
    private static ContentManager sContentManager;

    public static ContentManager getContentManager() {
        if (sContentManager == null)
            sContentManager = new ContentManager();
        return sContentManager;
    }
}
