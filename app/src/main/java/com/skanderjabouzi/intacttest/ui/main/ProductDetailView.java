package com.skanderjabouzi.intacttest.ui.main;

import com.skanderjabouzi.intacttest.adapter.ProductColorAdapter;
import java.util.List;

public interface ProductDetailView {
    void showProductImage(String imageString);
    void showProductTitle(String title);
    void showProductDescription(String description);
    void showProductPrice(String price);
    void showProductColorAttributes(ProductColorAdapter adapter);
    void showProductSizeAttributes(String sizes);
    void setProductRate(List<Integer> rates);
    void addToWishList(int color, int text);
}
