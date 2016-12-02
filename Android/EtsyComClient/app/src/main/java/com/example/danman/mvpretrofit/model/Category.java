package com.example.danman.mvpretrofit.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by DanMan on 10.10.2016.
 */
public class Category extends RealmObject {
    @PrimaryKey
    @SerializedName("category_id")
    private String mCategoryId;
    @SerializedName("name")
    private String mName;
    @SerializedName("meta_title")
    private String mMetaTitle;
    @SerializedName("meta_keywords")
    private String mMetaKeywords;
    @SerializedName("meta_description")
    private String mMetaDescription;
    @SerializedName("page_description")
    private String mPageDescription;
    @SerializedName("page_title")
    private String mPageTitle;
    @SerializedName("category_name")
    private String mCategoryName;
    @SerializedName("short_name")
    private String mShortName;
    @SerializedName("long_name")
    private String mLongName;
    @SerializedName("num_children")
    private String mNumChildren;
    public Category(){}
    public String getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(String categoryId) {
        mCategoryId = categoryId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getMetaTitle() {
        return mMetaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        mMetaTitle = metaTitle;
    }

    public String getMetaKeywords() {
        return mMetaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        mMetaKeywords = metaKeywords;
    }

    public String getMetaDescription() {
        return mMetaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        mMetaDescription = metaDescription;
    }

    public String getPageDescription() {
        return mPageDescription;
    }

    public void setPageDescription(String pageDescription) {
        mPageDescription = pageDescription;
    }

    public String getPageTitle() {
        return mPageTitle;
    }

    public void setPageTitle(String pageTitle) {
        mPageTitle = pageTitle;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public void setCategoryName(String categoryName) {
        mCategoryName = categoryName;
    }

    public String getShortName() {
        return mShortName;
    }

    public void setShortName(String shortName) {
        mShortName = shortName;
    }

    public String getLongName() {
        return mLongName;
    }

    public void setLongName(String longName) {
        mLongName = longName;
    }

    public String getNumChildren() {
        return mNumChildren;
    }

    public void setNumChildren(String numChildren) {
        mNumChildren = numChildren;
    }
}
