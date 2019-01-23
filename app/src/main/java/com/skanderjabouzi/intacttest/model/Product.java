
package com.skanderjabouzi.intacttest.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("product_name")
    @Expose
    private String productName;
    @SerializedName("product_colors")
    @Expose
    private List<ProductColor> productColors = null;
    @SerializedName("product_size")
    @Expose
    private ProductSize productSize;
    @SerializedName("product_description")
    @Expose
    private String productDescription;
    @SerializedName("product_price")
    @Expose
    private String productPrice;
    @SerializedName("product_materials")
    @Expose
    private String productMaterials;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<ProductColor> getProductColors() {
        return productColors;
    }

    public void setProductColors(List<ProductColor> productColors) {
        this.productColors = productColors;
    }

    public ProductSize getProductSize() {
        return productSize;
    }

    public void setProductSize(ProductSize productSize) {
        this.productSize = productSize;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductMaterials() {
        return productMaterials;
    }

    public void setProductMaterials(String productMaterials) {
        this.productMaterials = productMaterials;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productColors=" + productColors +
                ", productSize=" + productSize +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productMaterials='" + productMaterials + '\'' +
                '}';
    }
}
