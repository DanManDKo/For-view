package com.example.danman.elementrd.model;


/**
 * Created by DanMan on 11.12.2016.
 */
public class SomeModel {
    private String image;
    private String textOne;
    private String textTwo;

    public SomeModel(String image, String textOne, String textTwo) {
        this.image = image;
        this.textOne = textOne;
        this.textTwo = textTwo;
    }

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
}
