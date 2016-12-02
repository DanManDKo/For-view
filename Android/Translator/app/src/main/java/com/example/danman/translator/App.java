package com.example.danman.translator;

import android.app.Application;

import com.example.danman.translator.manager.ApiManager;
import com.example.danman.translator.manager.SpinnerManager;

/**
 * Created by DanMan on 01.12.2016.
 */
public class App extends Application {
    private static ApiManager sApiManager;
    private static SpinnerManager sSpinnerManager;

    public static ApiManager getApiManager() {
        if (sApiManager == null) {
            sApiManager = new ApiManager();
            sApiManager.init();
        }
        return sApiManager;
    }

    public static SpinnerManager getSpinnerManager() {
        if (sSpinnerManager == null)
            sSpinnerManager = new SpinnerManager();
        return sSpinnerManager;
    }

}
