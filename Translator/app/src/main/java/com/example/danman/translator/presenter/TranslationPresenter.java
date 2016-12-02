package com.example.danman.translator.presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.danman.translator.App;
import com.example.danman.translator.contract.TranslationContract;
import com.example.danman.translator.model.TranslationResult;

import java.util.Map;

import retrofit2.Response;
import rx.Subscriber;

/**
 * Created by DanMan on 01.12.2016.
 */
public class TranslationPresenter implements TranslationContract.presenter {
    private TranslationContract.View mView;

    public boolean isOnline() {
        ConnectivityManager manager = (ConnectivityManager) mView.getContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        }
        return isAvailable;
    }

    @Override
    public void translate(Map<String, String> fields) {
        App.getApiManager().translate(fields).subscribe(new Subscriber<Response<TranslationResult>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.onError(e);
            }

            @Override
            public void onNext(Response<TranslationResult> translationResultResponse) {
                TranslationResult translationResult = translationResultResponse.body();
                mView.onTranslationResult(translationResult);
            }
        });
    }

    @Override
    public void attachView(TranslationContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
