package com.skanderjabouzi.intacttest.ui.main;

import android.util.Log;

import com.skanderjabouzi.intacttest.event.CatalogEvents;
import com.skanderjabouzi.intacttest.event.GlobalBus;
import com.skanderjabouzi.intacttest.model.Product;

import org.greenrobot.eventbus.Subscribe;

public class ProductDetailPresenter {
    ProductDetailView productDetailView;

    public void setProductDetailView(ProductDetailView view) {
        productDetailView = view;
    }

    public void OnResume() {
        GlobalBus.getBus().register(this);
    }

    public void onPause() {
        GlobalBus.getBus().unregister(this);
    }

    @Subscribe(sticky = true)
    public void onEvent(CatalogEvents.ProductEvent event) {
        Log.e("EVENT", event.getMessage());
        if (event.getMessage().equals("ShowProductDetail")) {
            Log.e("PRODUCT", event.getPrpduct().toString());
            Product product = event.getPrpduct();
            productDetailView.showProductTitle(product.getProductName());
            productDetailView.showProductImage("img"+product.getId());
            productDetailView.showProductPrice(Double.valueOf(product.getProductPrice()));
            productDetailView.showProductDescription(product.getProductDescription());
        }
    }
}
