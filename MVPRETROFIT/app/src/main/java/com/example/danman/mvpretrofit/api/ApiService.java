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
    String API_KEY = "api_key";
    String CATEGORY = "category";
    String PAGE = "page";
    String INCLUDES = "includes";
    String CATEGORY_REQUEST = "/v2/taxonomy/categories";
    String PRODUCT_REQUEST = "/v2/listings/active";

    @GET(CATEGORY_REQUEST)
    Observable<retrofit2.Response<Response<Category>>> loadCategories(@Query(API_KEY) String apiKey);

    @GET(PRODUCT_REQUEST)
    Observable<retrofit2.Response<Response<Product>>> loadProducts(@Query(API_KEY) String apiKey,
                                                                   @Query(CATEGORY) String category,
                                                                   @Query(PAGE) int page,
                                                                   @Query(INCLUDES) String images);


}
