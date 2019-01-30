package com.skanderjabouzi.intacttest.ui.main;

import android.content.Context;

import com.skanderjabouzi.intacttest.R;
import com.skanderjabouzi.intacttest.adapter.ProductColorAdapter;
import com.skanderjabouzi.intacttest.dao.CatalogData;
import com.skanderjabouzi.intacttest.event.CatalogEvents;
import com.skanderjabouzi.intacttest.event.GlobalBus;
import com.skanderjabouzi.intacttest.model.Product;
import com.skanderjabouzi.intacttest.model.ProductColor;
import com.skanderjabouzi.intacttest.model.ProductSize;

import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailPresenter {
    ProductDetailView productDetailView;
    Context context;
    Product product;

    public void setProductDetailView(ProductDetailView view, Context context) {
        productDetailView = view;
        this.context = context;
    }

    public void onResume() {
        GlobalBus.getBus().register(this);
    }

    public void onPause() {
        GlobalBus.getBus().unregister(this);
    }

    @Subscribe(sticky = true)
    public void onEvent(CatalogEvents.ProductEvent event) {
        if (event.getMessage().equals("ShowProductDetail")) {
            product = event.getPrpduct();
            initViews();
            initRate();
            initWishListButton();
        }
    }

    public void initViews() {
        productDetailView.showProductTitle(product.getProductName());
        productDetailView.showProductImage("img"+product.getId());
        productDetailView.showProductPrice(Double.valueOf(product.getProductPrice()));
        productDetailView.showProductDescription(product.getProductDescription());
        productDetailView.showProductColorAttributes(getAdapter(product.getProductColors()));
        productDetailView.showProductSizeAttributes(getSize(product.getProductSize()));
    }

    public void initRate() {
        productDetailView.setProductRate(setStarts(product.getProductRate()));
    }

    public void starClicked(Integer rate) {
        CatalogData.updateRating(product, rate);
        productDetailView.setProductRate(setStarts(rate));
    }

    public void toggleWishList() {
        if (CatalogData.isInWishList(product)) {
            CatalogData.removeProductFromWishList(product);
            productDetailView.addToWishList(R.color.ColorButton, R.string.add_to_widhlist);
        }
        else {
            CatalogData.addProductToWishList(product);
            productDetailView.addToWishList(R.color.ColorButtonWishList, R.string.remove_from_wishlist);
        }
    }

    private ProductColorAdapter getAdapter(List<ProductColor> colors) {
        return new ProductColorAdapter(this.context, colors);
    }

    private String getSize(ProductSize size) {
        String dimension = "";
        if (!StringUtils.isEmpty(size.getWidth())) dimension += context.getResources().getString(R.string.width) + ":" + size.getWidth() + "\n";
        if (!StringUtils.isEmpty(size.getHeight())) dimension += context.getResources().getString(R.string.height) + ":" + size.getHeight() + "\n";
        if (!StringUtils.isEmpty(size.getDepth())) dimension += context.getResources().getString(R.string.depth) + ":" + size.getDepth() + "\n";

        return dimension;
    }

    private void initWishListButton() {
        if (!CatalogData.isInWishList(product)) {
            CatalogData.removeProductFromWishList(product);
            productDetailView.addToWishList(R.color.ColorButton, R.string.add_to_widhlist);
        }
        else {
            CatalogData.addProductToWishList(product);
            productDetailView.addToWishList(R.color.ColorButtonWishList, R.string.remove_from_wishlist);
        }
    }

    private ArrayList<Integer> setStarts(Integer rate) {
        ArrayList<Integer> stars = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            stars.add(R.mipmap.star_grey);
        }

        if (rate > 0) {
            stars.set(0, R.mipmap.star_yellow);
        }

        if (rate > 1) {
            stars.set(1, R.mipmap.star_yellow);
        }

        if (rate > 2) {
            stars.set(2, R.mipmap.star_yellow);
        }

        if (rate > 3) {
            stars.set(3, R.mipmap.star_yellow);
        }

        if (rate > 4) {
            stars.set(4, R.mipmap.star_yellow);
        }

        return stars;
    }
}
