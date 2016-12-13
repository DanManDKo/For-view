package com.example.danman.testapp.ui.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DanMan on 12.12.2016.
 */
public class SomeModel implements Parcelable {
    private String image;
    private String textOne;
    private String textTwo;

    public SomeModel(String image, String textOne, String textTwo) {
        this.image = image;
        this.textOne = textOne;
        this.textTwo = textTwo;
    }

    protected SomeModel(Parcel in) {
        image = in.readString();
        textOne = in.readString();
        textTwo = in.readString();
    }

    public static final Creator<SomeModel> CREATOR = new Creator<SomeModel>() {
        @Override
        public SomeModel createFromParcel(Parcel in) {
            return new SomeModel(in);
        }

        @Override
        public SomeModel[] newArray(int size) {
            return new SomeModel[size];
        }
    };

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTextOne() {
        return textOne;
    }

    public void setTextOne(String textOne) {
        this.textOne = textOne;
    }

    public String getTextTwo() {
        return textTwo;
    }

    public void setTextTwo(String textTwo) {
        this.textTwo = textTwo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(image);
        parcel.writeString(textOne);
        parcel.writeString(textTwo);
    }
}
