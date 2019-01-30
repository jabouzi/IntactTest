package com.skanderjabouzi.intacttest.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.skanderjabouzi.intacttest.R;
import com.skanderjabouzi.intacttest.dao.CatalogData;
import com.skanderjabouzi.intacttest.helper.AsyncTaskHelper;
import com.skanderjabouzi.intacttest.helper.CatalogHelper;
import com.skanderjabouzi.intacttest.model.Product;
import com.skanderjabouzi.intacttest.model.Products;

public class SplashActivity extends AppCompatActivity implements CatalogHelper.Observer {

    private AsyncTaskHelper asyncTaskHelper;
    private CatalogHelper catalogHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        asyncTaskHelper = new AsyncTaskHelper();
        catalogHelper = new CatalogHelper();
        catalogHelper.setObserver(this);
        initCatalog();
    }

    private void initCatalog() {
        asyncTaskHelper.execute(new AsyncTaskHelper.DoSomething() {
            @Override
            public void doItInBackground() {
                catalogHelper.getCatalogProducts();
            }

            @Override
            public void doItPostExecute() {

            }
        });
    }

    @Override
    public void catalogProductsSucceed(Products products) {
        for(Product product : products.getProducts()) {
            CatalogData.catalog.put(product.getId(), product);
        }
        Intent intent = new Intent(this, CatalogActivity.class);
        startActivity(intent);
    }

    @Override
    public void catalogProductsFailed() {

    }
}
