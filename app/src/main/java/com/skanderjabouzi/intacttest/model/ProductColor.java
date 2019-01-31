package com.skanderjabouzi.intacttest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductColor {

    @SerializedName("color_name")
    @Expose
    private String colorName;
    @SerializedName("color_code")
    @Expose
    private String colorCode;

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    @Override
    public String toString() {
        return "ProductColor{" +
                "colorName='" + colorName + '\'' +
                ", colorCode='" + colorCode + '\'' +
                '}';
    }
}
