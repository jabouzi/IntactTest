package com.skanderjabouzi.intacttest.app;

import android.app.Application;
import android.content.Context;
import com.skanderjabouzi.intacttest.model.Product;
import java.util.ArrayList;

public class CatalogApp extends Application {
    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
    }

    public static Context getContext() {
        return appContext;
    }


}
