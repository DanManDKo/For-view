package com.example.danman.translator.manager;

import com.example.danman.translator.api.ApiService;
import com.example.danman.translator.api.ApiSettings;
import com.example.danman.translator.model.TranslationResult;
import com.google.gson.GsonBuilder;

import java.util.Map;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DanMan on 01.12.2016.
 */
public class ApiManager {
    private Retrofit mRetrofit;
    private ApiService mApiService;

    public void init() {
        initRetrofit();
        initServices();
    }

    private void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(ApiSettings.SERVER)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(createGsonConverter())
                .build();
    }

    private void initServices() {
        mApiService = mRetrofit.create(ApiService.class);
    }

    private GsonConverterFactory createGsonConverter() {
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        return GsonConverterFactory.create(builder.create());
    }

    public Observable<Response<TranslationResult>> translate(Map<String,String>fields) {
        return mApiService.translate(fields)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
