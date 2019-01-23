package com.skanderjabouzi.intacttest.helper;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.skanderjabouzi.intacttest.app.CatalogApp;
import com.skanderjabouzi.intacttest.model.Products;

import java.io.IOException;
import java.io.InputStream;

public class CatalogHelper {

    public interface Observer {
        void catalogProductsSucceed(Products products);
        void catalogProductsFailed();
    }

    private Observer observer;

    public void setObserver(Observer observer){
        this.observer = observer;
    }

    public void getCatalogProducts() {
        Gson gson = new GsonBuilder().create();
        Products products = gson.fromJson(loadJSONFromAsset(), Products.class);
        if (observer != null)
        {
            observer.catalogProductsSucceed(products);
        }
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = CatalogApp.getContext().getAssets().open("products.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            Log.e("JSON", json);
        } catch (IOException e) {
            Log.e("CatalogHelper", e.getMessage(), e);
            if (observer != null)
            {
                observer.catalogProductsFailed();
            }
            return null;
        }
        return json;
    }
}
