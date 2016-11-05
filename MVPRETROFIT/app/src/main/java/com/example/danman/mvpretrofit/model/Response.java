package com.example.danman.mvpretrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by DanMan on 10.10.2016.
 */
public class Response<T> {
    @SerializedName("count")
    private String mCount;
    @SerializedName("results")
    private List<T> mResults;
//    @SerializedName("params")
//    private String mParams;
    @SerializedName("type")
    private String mType;
    //private String pagination;

    public String getCount() {
        return mCount;
    }

    public void setCount(String count) {
        mCount = count;
    }

    public List<T> getResults() {

        return mResults;
    }

    public void setResults(List<T> results) {
        mResults = results;
    }

//    public String getParams() {
//        return mParams;
//    }

//    public void setParams(String params) {
//        mParams = params;
////    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }
}
