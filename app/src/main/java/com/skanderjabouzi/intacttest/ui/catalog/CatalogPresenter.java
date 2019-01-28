package com.skanderjabouzi.intacttest.ui.catalog;

import android.content.Context;

import com.skanderjabouzi.intacttest.adapter.CatalogListAdapter;
import com.skanderjabouzi.intacttest.helper.CatalogHelper;
import com.skanderjabouzi.intacttest.model.Products;

public class CatalogPresenter implements CatalogHelper.Observer{
    CatalogView catalogView;
    Context context;

    public CatalogPresenter(CatalogView view, Context context) {
        this.catalogView = view;
        this.context = context;
        setCatalog();
    }

    public void setCatalog() {
        CatalogHelper catalogHelper = new CatalogHelper();
        catalogHelper.setObserver(this);
        catalogHelper.getCatalogProducts();
    }

    @Override
    public void catalogProductsSucceed(Products products) {
        CatalogListAdapter adapter = new CatalogListAdapter(context, products.getProducts());
        catalogView.setupAdapter(adapter);
    }

    @Override
    public void catalogProductsFailed() {
//        todo add products retreive failed callback
    }
}
