package com.example.danman.translator.model;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by DanMan on 01.12.2016.
 */
public class TranslationResult {
    @SerializedName("code")
    private String code;
    @SerializedName("lang")
    private String language;
    @SerializedName("text")
    private String[] text;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TranslationResult response = (TranslationResult) o;

        if (code != null ? !code.equals(response.code) : response.code != null) return false;
        if (language != null ? !language.equals(response.language) : response.language != null)
            return false;
        return Arrays.equals(text, response.text);

    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(text);
        return result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String[] getText() {
        return text;
    }

    public void setText(String[] text) {
        this.text = text;
    }
}
