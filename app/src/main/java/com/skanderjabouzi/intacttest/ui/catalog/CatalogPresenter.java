package com.skanderjabouzi.intacttest.ui.catalog;

import android.content.Context;

import com.skanderjabouzi.intacttest.adapter.CatalogListAdapter;
import com.skanderjabouzi.intacttest.dao.CatalogData;
import com.skanderjabouzi.intacttest.helper.CatalogHelper;
import com.skanderjabouzi.intacttest.model.Product;
import com.skanderjabouzi.intacttest.model.Products;

import java.util.ArrayList;
import java.util.List;

public class CatalogPresenter{
    CatalogView catalogView;
    Context context;

    public CatalogPresenter(CatalogView view, Context context) {
        this.catalogView = view;
        this.context = context;
        setCatalog();
    }

    public void setCatalog() {
        CatalogListAdapter adapter = new CatalogListAdapter(context, new ArrayList<Product>(CatalogData.catalog.values()));
        catalogView.setupAdapter(adapter);
    }
}
