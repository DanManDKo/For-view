package com.example.danman.translator.presenter;

/**
 * Created by DanMan on 01.12.2016.
 */
public interface BaseMvpPresenter<V> {
    void attachView(V view);

    void detachView();
}
