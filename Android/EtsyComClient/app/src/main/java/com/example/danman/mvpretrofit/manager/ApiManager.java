package com.example.danman.mvpretrofit.manager;

import com.example.danman.mvpretrofit.api.ApiService;
import com.example.danman.mvpretrofit.model.Category;
import com.example.danman.mvpretrofit.model.Product;
import com.example.danman.mvpretrofit.model.Response;
import com.google.gson.GsonBuilder;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DanMan on 10.10.2016.
 */
public class ApiManager {
    public static final String SCHEME = "https://";
    public static final String HOSTNAME = "openapi.etsy.com/";
    public static final String ETSY_API_KEY = "l6pdqjuf7hdf97h1yvzadfce";
    public static final String IMAGES = "Images";
    public static final String SERVER = SCHEME + HOSTNAME;
    private Retrofit mRetrofit;
    private ApiService mApiService;

    public void init() {
        initRetrofit();
        initServices();
    }

    private void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(SERVER)
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

    public Observable<retrofit2.Response<Response<Category>>> loadCategories() {
        return mApiService.loadCategories(ETSY_API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<retrofit2.Response<Response<Product>>> loadProducts(String categoryName, int page) {
        return mApiService.loadProducts(ETSY_API_KEY, categoryName, page, IMAGES).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }


}
