package com.example.danman.mvpretrofit.presenter;

/**
 * Created by DanMan on 11.10.2016.
 */
public interface BaseMvpPresenter<V> {
    void attachView(V view);

    void detachView();
}
