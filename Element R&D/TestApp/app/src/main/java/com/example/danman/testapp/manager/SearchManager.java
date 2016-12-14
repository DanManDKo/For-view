package com.example.danman.testapp.manager;


import com.example.danman.testapp.ui.activity.MainActivity;
import com.example.danman.testapp.ui.fragment.PageFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DanMan on 13.12.2016.
 */
public class SearchManager {
    private List<MainActivity.OnTextChangedCallback> mListeners = new ArrayList();
    public void setListeners(List<PageFragment> listeners) {
        mListeners.addAll(listeners);
    }

    public void sendQuery(int position, String query) {
        mListeners.get(position).onTextChange(query.toLowerCase());
    }
}
