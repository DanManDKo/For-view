package com.example.danman.mvpretrofit.contract;


import com.example.danman.mvpretrofit.model.Category;
import com.example.danman.mvpretrofit.presenter.BaseMvpPresenter;

import java.util.List;

/**
 * Created by DanMan on 11.10.2016.
 */
public class CategoriesContract {
    public interface presenter extends BaseMvpPresenter<iView> {
        void loadCategoriesFromNetwork();

        boolean isOnline();

        void loadCategoriesFromDB();

        void saveCategoriesToDB(List<Category> categories);
    }


    public interface iView {
        void onCategoriesLoaded(List<Category> categories);

        void onError(String message);
    }
}
