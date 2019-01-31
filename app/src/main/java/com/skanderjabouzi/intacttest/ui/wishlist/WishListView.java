package com.skanderjabouzi.intacttest.ui.wishlist;

import com.skanderjabouzi.intacttest.adapter.WishListAdapter;

public interface WishListView {
    void setWishListViewEmpty();
    void setWishListViewNotEmpty();
    void setWishListTotal(Double sum);
    void setupAdapter(WishListAdapter adapter);
}
