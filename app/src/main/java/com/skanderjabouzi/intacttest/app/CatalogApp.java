package com.skanderjabouzi.intacttest.app;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.skanderjabouzi.intacttest.helper.CatalogHelper;
import com.skanderjabouzi.intacttest.model.Products;

public class CatalogApp extends Application implements CatalogHelper.Observer {
    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
        CatalogHelper catalogHelper = new CatalogHelper();
        catalogHelper.setObserver(this);
        catalogHelper.getCatalogProducts();
    }

    public static Context getContext() {
        return appContext;
    }

    @Override
    public void catalogProductsSucceed(Products products) {
        Log.e("APP PRODUCTS", products.getProducts().toString());
    }

    @Override
    public void catalogProductsFailed() {
        Log.e("APP PRODUCTS", "FAILED");
    }
}
