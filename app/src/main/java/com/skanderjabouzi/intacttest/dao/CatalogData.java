package com.skanderjabouzi.intacttest.dao;

import android.widget.Toast;

import com.skanderjabouzi.intacttest.R;
import com.skanderjabouzi.intacttest.app.CatalogApp;
import com.skanderjabouzi.intacttest.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CatalogData {
    public static ArrayList<Product> wishList = new ArrayList<>();
    public static Map<Integer, Product> catalog = new HashMap<>();

    public static boolean isInWishList(Product product) {
        return catalog.get(product.getId()).isInWishList();
    }

    public static void addProductToWishList(Product product) {
        wishList.add(product);
        catalog.get(product.getId()).setInWishList(true);
        Toast.makeText(CatalogApp.getContext(), CatalogApp.getContext().getString(R.string.added_to_wishlist), Toast.LENGTH_LONG).show();
    }

    public static void removeProductFromWishList(Product product) {
        wishList.remove(product);
        catalog.get(product.getId()).setInWishList(false);
        Toast.makeText(CatalogApp.getContext(), CatalogApp.getContext().getString(R.string.removed_from_wishlist), Toast.LENGTH_LONG).show();
    }

    public static void updateRating(Product product, int rating) {
         catalog.get(product.getId()).setProductRate(rating);
    }
}
