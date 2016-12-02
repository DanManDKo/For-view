package com.example.danman.translator.contract;

import android.content.Context;

import com.example.danman.translator.model.TranslationResult;
import com.example.danman.translator.presenter.BaseMvpPresenter;

import java.util.List;
import java.util.Map;

/**
 * Created by DanMan on 01.12.2016.
 */
public class TranslationContract {
    public interface presenter extends BaseMvpPresenter<View> {

        boolean isOnline();

        void translate(Map<String, String> fields);

    }


    public interface View {
        void onTranslationResult(TranslationResult result);

        Context getContext();

        void onError(Throwable throwable);
    }
}
