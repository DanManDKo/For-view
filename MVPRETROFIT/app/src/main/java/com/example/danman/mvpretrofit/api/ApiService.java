package com.example.danman.mvpretrofit.api;

import com.example.danman.mvpretrofit.model.Category;
import com.example.danman.mvpretrofit.model.Product;
import com.example.danman.mvpretrofit.model.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by DanMan on 10.10.2016.
 */
public interface ApiService {
    @GET("/v2/taxonomy/categories")
    Observable<retrofit2.Response<Response<Category>>> loadCategories(@Query("api_key") String apiKey);

    @GET("/v2/listings/active")
    Observable<retrofit2.Response<Response<Product>>> loadProducts(@Query("api_key") String apiKey,
                                         @Query("category") String category,
                                         @Query("page") int page,
                                         @Query("includes") String images);



}
