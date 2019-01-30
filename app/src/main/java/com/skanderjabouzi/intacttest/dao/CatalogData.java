package com.skanderjabouzi.intacttest.dao;

import com.skanderjabouzi.intacttest.model.Product;

import java.util.ArrayList;
import java.util.HashMap;

public class CatalogData {
    public static ArrayList<Product> wishList = new ArrayList<Product>();
    public static HashMap<Integer, Product> catalog = new HashMap<>();

    public static boolean isInWishList(Product product) {
        return catalog.get(product.getId()).isInWishList();
    }

    public static void addProductToWishList(Product product) {
        wishList.add(product);
        catalog.get(product.getId()).setInWishList(true);
    }

    public static void removeProductFromWishList(Product product) {
        wishList.remove(product);
        catalog.get(product.getId()).setInWishList(false);
    }

    public static void updateRating(Product product, int rating) {
         catalog.get(product.getId()).setProductRate(rating);
    }
}
