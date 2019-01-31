package com.skanderjabouzi.intacttest.ui.wishlist;

import android.content.Context;
import com.skanderjabouzi.intacttest.adapter.WishListAdapter;
import com.skanderjabouzi.intacttest.dao.CatalogData;


public class WishListPresenter{
    WishListView wishListView;
    Context context;

    public WishListPresenter(WishListView view, Context context) {
        this.wishListView = view;
        this.context = context;
        setWishListView();
    }

    public void setWishListView() {
        if (CatalogData.wishList.size() > 0) {
            wishListView.setWishListViewNotEmpty();
            setCatalog();
            Double sum = 0.0;
            for (int i = 0; i < CatalogData.wishList.size(); i++) {
                sum += Double.valueOf(CatalogData.wishList.get(i).getProductPrice());
            }
            wishListView.setWishListTotal(sum);
        } else {
            wishListView.setWishListViewEmpty();
        }
    }

    public void setCatalog() {
        WishListAdapter adapter = new WishListAdapter(context, CatalogData.wishList);
        wishListView.setupAdapter(adapter);
    }
}