package com.example.danman.translator.api;

import com.example.danman.translator.model.TranslationResult;

import java.util.Map;

import retrofit2.Response;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by DanMan on 01.12.2016.
 */
public interface ApiService {
    @FormUrlEncoded
    @POST("/api/v1.5/tr.json/translate")
    Observable<Response<TranslationResult>> translate(@FieldMap Map<String, String> fields);

}
