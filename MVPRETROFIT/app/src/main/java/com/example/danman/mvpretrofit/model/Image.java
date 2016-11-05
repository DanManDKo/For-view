package com.example.danman.mvpretrofit.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by DanMan on 18.10.2016.
 */
public class Image extends RealmObject implements Parcelable {
    @SerializedName("listing_image_id")
    private String listingImageId;
    @SerializedName("hex_code")
    private String hexCode;
    @SerializedName("red")
    private String red;
    @SerializedName("green")
    private String green;
    @SerializedName("blue")
    private String blue;
    @SerializedName("hue")
    private String hue;
    @SerializedName("saturation")
    private String saturation;
    @SerializedName("brightness")
    private String brightness;
    @SerializedName("is_black_and_white")
    private String blackAndWhite;
    @SerializedName("creation_tsz")
    private String creationTsz;
    @SerializedName("listing_id")
    private String productId;
    @SerializedName("rank")
    private String rank;
    @SerializedName("url_75x75")
    private String url75x75;
    @SerializedName("url_170x135")
    private String url170x135;
    @SerializedName("url_570xN")
    private String url570xN;
    @SerializedName("url_fullxfull")
    private String urlFullxFull;
    @SerializedName("full_height")
    private String fullHeight;
    @SerializedName("full_width")
    private String fullWidth;
    public Image(){}
    protected Image(Parcel in) {
        listingImageId = in.readString();
        hexCode = in.readString();
        red = in.readString();
        green = in.readString();
        blue = in.readString();
        hue = in.readString();
        saturation = in.readString();
        brightness = in.readString();
        blackAndWhite = in.readString();
        creationTsz = in.readString();
        productId = in.readString();
        rank = in.readString();
        url75x75 = in.readString();
        url170x135 = in.readString();
        url570xN = in.readString();
        urlFullxFull = in.readString();
        fullHeight = in.readString();
        fullWidth = in.readString();
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    public void setListingImageId(String listingImageId) {
        this.listingImageId = listingImageId;
    }

    public void setHexCode(String hexCode) {
        this.hexCode = hexCode;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public void setGreen(String green) {
        this.green = green;
    }

    public void setBlue(String blue) {
        this.blue = blue;
    }

    public void setHue(String hue) {
        this.hue = hue;
    }

    public void setSaturation(String saturation) {
        this.saturation = saturation;
    }

    public void setBrightness(String brightness) {
        this.brightness = brightness;
    }

    public void setBlackAndWhite(String blackAndWhite) {
        this.blackAndWhite = blackAndWhite;
    }

    public void setCreationTsz(String creationTsz) {
        this.creationTsz = creationTsz;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setUrl75x75(String url75x75) {
        this.url75x75 = url75x75;
    }

    public void setUrl170x135(String url170x135) {
        this.url170x135 = url170x135;
    }

    public void setUrl570xN(String url570xN) {
        this.url570xN = url570xN;
    }

    public void setUrlFullxFull(String urlFullxFull) {
        this.urlFullxFull = urlFullxFull;
    }

    public void setFullHeight(String fullHeight) {
        this.fullHeight = fullHeight;
    }

    public void setFullWidth(String fullWidth) {
        this.fullWidth = fullWidth;
    }

    public String getListingImageId() {
        return listingImageId;
    }

    public String getHexCode() {
        return hexCode;
    }

    public String getRed() {
        return red;
    }

    public String getGreen() {
        return green;
    }

    public String getBlue() {
        return blue;
    }

    public String getHue() {
        return hue;
    }

    public String getSaturation() {
        return saturation;
    }

    public String getBrightness() {
        return brightness;
    }

    public String getBlackAndWhite() {
        return blackAndWhite;
    }

    public String getCreationTsz() {
        return creationTsz;
    }

    public String getProductId() {
        return productId;
    }

    public String getRank() {
        return rank;
    }

    public String getUrl75x75() {
        return url75x75;
    }

    public String getUrl170x135() {
        return url170x135;
    }

    public String getUrl570xN() {
        return url570xN;
    }

    public String getUrlFullxFull() {
        return urlFullxFull;
    }

    public String getFullHeight() {
        return fullHeight;
    }

    public String getFullWidth() {
        return fullWidth;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(listingImageId);
        parcel.writeString(hexCode);
        parcel.writeString(red);
        parcel.writeString(green);
        parcel.writeString(blue);
        parcel.writeString(hue);
        parcel.writeString(saturation);
        parcel.writeString(brightness);
        parcel.writeString(blackAndWhite);
        parcel.writeString(creationTsz);
        parcel.writeString(productId);
        parcel.writeString(rank);
        parcel.writeString(url75x75);
        parcel.writeString(url170x135);
        parcel.writeString(url570xN);
        parcel.writeString(urlFullxFull);
        parcel.writeString(fullHeight);
        parcel.writeString(fullWidth);
    }
}
