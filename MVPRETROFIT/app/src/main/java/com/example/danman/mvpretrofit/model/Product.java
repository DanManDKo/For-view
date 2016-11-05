package com.example.danman.mvpretrofit.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by DanMan on 11.10.2016.
 */
public class Product extends RealmObject implements Parcelable {
    @SerializedName("listing_id")
    private String productId;
    @SerializedName("state")
    private String state;
    @SerializedName("category_id")
    private String categoryId;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("price")
    private String price;
    @SerializedName("currency_code")
    private String currencyCode;
    @SerializedName("quantity")
    private String quantity;
    @SerializedName("item_weight")
    private String itemWeight;
    @SerializedName("Images")
    private RealmList<Image> images;
    private boolean favorite;

    protected Product(Parcel in) {
        productId = in.readString();
        state = in.readString();
        categoryId = in.readString();
        title = in.readString();
        description = in.readString();
        price = in.readString();
        currencyCode = in.readString();
        quantity = in.readString();
        itemWeight = in.readString();
        List<Image> img = in.createTypedArrayList(Image.CREATOR);
        images = new RealmList<>(img.toArray(new Image[img.size()]));
    }

    public Product() {
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public void setImages(RealmList<Image> images) {
        this.images = images;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setItemWeight(String itemWeight) {
        this.itemWeight = itemWeight;
    }

    public String getProductId() {
        return productId;
    }

    public String getState() {
        return state;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getItemWeight() {
        return itemWeight;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public List<Image> getImages() {
        return images;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(productId);
        parcel.writeString(state);
        parcel.writeString(categoryId);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(price);
        parcel.writeString(currencyCode);
        parcel.writeString(quantity);
        parcel.writeString(itemWeight);
        parcel.writeTypedList(images);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (favorite != product.favorite) return false;
        if (productId != null ? !productId.equals(product.productId) : product.productId != null)
            return false;
        if (state != null ? !state.equals(product.state) : product.state != null) return false;
        if (categoryId != null ? !categoryId.equals(product.categoryId) : product.categoryId != null)
            return false;
        if (title != null ? !title.equals(product.title) : product.title != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null)
            return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (currencyCode != null ? !currencyCode.equals(product.currencyCode) : product.currencyCode != null)
            return false;
        if (quantity != null ? !quantity.equals(product.quantity) : product.quantity != null)
            return false;
        if (itemWeight != null ? !itemWeight.equals(product.itemWeight) : product.itemWeight != null)
            return false;
        return images != null ? images.equals(product.images) : product.images == null;

    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (currencyCode != null ? currencyCode.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (itemWeight != null ? itemWeight.hashCode() : 0);
        result = 31 * result + (images != null ? images.hashCode() : 0);
        result = 31 * result + (favorite ? 1 : 0);
        return result;
    }
}
