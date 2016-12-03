package com.example.danman.translator.presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;

import com.example.danman.translator.App;
import com.example.danman.translator.R;
import com.example.danman.translator.contract.TranslationContract;
import com.example.danman.translator.model.TranslationResult;
import com.example.danman.translator.ui.activity.MainActivity;
import com.example.danman.translator.util.XmlParser;

import java.util.Map;

import retrofit2.Response;
import rx.Subscriber;

/**
 * Created by DanMan on 01.12.2016.
 */
public class TranslationPresenter implements TranslationContract.presenter {
    private TranslationContract.View mView;
    private boolean isOnline;
    private Map<String, String> mDictionary;
    private boolean isFirstTime = true;

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
        isOnline = isOnline();
        if (isOnline()) {
            isFirstTime = true;
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
        } else {
            if (isFirstTime) {
                showAlert();
                isFirstTime = false;
            }
            if (mDictionary == null)
                mDictionary = XmlParser.getDictionary(mView.getContext());
            TranslationResult translationResult = new TranslationResult();
            String str = mDictionary.get(fields.get(MainActivity.TEXT));
            if (str != null && !str.isEmpty()) {
                translationResult.setText(new String[]{str});
                mView.onTranslationResult(translationResult);
            } else
                mView.onTranslationResult(null);

        }
    }

    @Override
    public void attachView(TranslationContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    private void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mView.getContext());
        builder.setTitle(R.string.connection_troubles)
                .setMessage(R.string.do_not_despair)
                .setIcon(R.drawable.dino)
                .setCancelable(false)
                .setNegativeButton(R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
