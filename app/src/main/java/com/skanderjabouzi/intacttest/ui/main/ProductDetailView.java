package com.skanderjabouzi.intacttest.ui.main;

public interface ProductDetailView {
    void showProductImage(String imageString);
    void showProductTitle(String title);
    void showProductDescription(String description);
    void showProductPrice(Double price);
    void showProductColorAttributes();
    void showProductSizeAttributes();
    void setProductRate();
    void addToWishList();
}
