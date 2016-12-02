package com.example.danman.translator.manager;

import android.animation.ObjectAnimator;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by DanMan on 02.12.2016.
 */
public class SpinnerManager {
    private HashMap<String, String> mLanguageMap;
    private List<String> mNames;

    public SpinnerManager() {
        mLanguageMap = new LinkedHashMap<>();
        mLanguageMap.put("English", "en");
        mLanguageMap.put("Ukrainian", "uk");
        mLanguageMap.put("Belarusian", "be");
        mLanguageMap.put("German", "de");
        mLanguageMap.put("Spanish", "es");
        mLanguageMap.put("French", "fr");
        mLanguageMap.put("Russian", "ru");
        mNames = new ArrayList<>(mLanguageMap.keySet());

    }


    public String getLngPair(Spinner from, Spinner to) {
        String str;

        str = mLanguageMap.get(from.getSelectedItem().toString())
                + "-"
                + mLanguageMap.get(to.getSelectedItem().toString());

        return str;
    }

    public List<String> getNamesList() {
        return mNames;
    }
}
