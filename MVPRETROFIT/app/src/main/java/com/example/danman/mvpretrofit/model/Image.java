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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (!listingImageId.equals(image.listingImageId)) return false;
        if (hexCode != null ? !hexCode.equals(image.hexCode) : image.hexCode != null) return false;
        if (red != null ? !red.equals(image.red) : image.red != null) return false;
        if (green != null ? !green.equals(image.green) : image.green != null) return false;
        if (blue != null ? !blue.equals(image.blue) : image.blue != null) return false;
        if (hue != null ? !hue.equals(image.hue) : image.hue != null) return false;
        if (saturation != null ? !saturation.equals(image.saturation) : image.saturation != null)
            return false;
        if (brightness != null ? !brightness.equals(image.brightness) : image.brightness != null)
            return false;
        if (blackAndWhite != null ? !blackAndWhite.equals(image.blackAndWhite) : image.blackAndWhite != null)
            return false;
        if (creationTsz != null ? !creationTsz.equals(image.creationTsz) : image.creationTsz != null)
            return false;
        if (productId != null ? !productId.equals(image.productId) : image.productId != null)
            return false;
        if (rank != null ? !rank.equals(image.rank) : image.rank != null) return false;
        if (url75x75 != null ? !url75x75.equals(image.url75x75) : image.url75x75 != null)
            return false;
        if (url170x135 != null ? !url170x135.equals(image.url170x135) : image.url170x135 != null)
            return false;
        if (url570xN != null ? !url570xN.equals(image.url570xN) : image.url570xN != null)
            return false;
        if (urlFullxFull != null ? !urlFullxFull.equals(image.urlFullxFull) : image.urlFullxFull != null)
            return false;
        if (fullHeight != null ? !fullHeight.equals(image.fullHeight) : image.fullHeight != null)
            return false;
        return fullWidth != null ? fullWidth.equals(image.fullWidth) : image.fullWidth == null;

    }

    @Override
    public int hashCode() {
        int result = listingImageId.hashCode();
        result = 31 * result + (hexCode != null ? hexCode.hashCode() : 0);
        result = 31 * result + (red != null ? red.hashCode() : 0);
        result = 31 * result + (green != null ? green.hashCode() : 0);
        result = 31 * result + (blue != null ? blue.hashCode() : 0);
        result = 31 * result + (hue != null ? hue.hashCode() : 0);
        result = 31 * result + (saturation != null ? saturation.hashCode() : 0);
        result = 31 * result + (brightness != null ? brightness.hashCode() : 0);
        result = 31 * result + (blackAndWhite != null ? blackAndWhite.hashCode() : 0);
        result = 31 * result + (creationTsz != null ? creationTsz.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + (url75x75 != null ? url75x75.hashCode() : 0);
        result = 31 * result + (url170x135 != null ? url170x135.hashCode() : 0);
        result = 31 * result + (url570xN != null ? url570xN.hashCode() : 0);
        result = 31 * result + (urlFullxFull != null ? urlFullxFull.hashCode() : 0);
        result = 31 * result + (fullHeight != null ? fullHeight.hashCode() : 0);
        result = 31 * result + (fullWidth != null ? fullWidth.hashCode() : 0);
        return result;
    }
}
