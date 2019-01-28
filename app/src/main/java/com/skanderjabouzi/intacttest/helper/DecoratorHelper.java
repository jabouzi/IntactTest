package com.skanderjabouzi.intacttest.helper;

import android.util.Log;

import com.skanderjabouzi.intacttest.R;
import com.skanderjabouzi.intacttest.app.CatalogApp;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class DecoratorHelper {

    private DecoratorHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static String formatDate(String date) {

        String formattedDate = "";
        SimpleDateFormat format;

        if (CatalogApp.getContext().getResources().getString(R.string.language_iso_639_1_code).equals("en")) {
            format = new SimpleDateFormat("MMM, dd yyyy");
        } else {
            format = new SimpleDateFormat("dd MMM yyyy");
        }
        SimpleDateFormat jsonFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

        try {
            formattedDate = format.format(jsonFormat.parse(date));
        } catch (Exception e) {
            Log.d("startDate", e.getMessage());
        }

        return formattedDate;
    }

    public static String formatCurrency(Double amount) {

        NumberFormat formatCurrency;
        if (CatalogApp.getContext().getResources().getString(R.string.language_iso_639_1_code).equals("en")) {
            formatCurrency = NumberFormat.getCurrencyInstance(Locale.CANADA);
        } else {
            formatCurrency = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH);
        }

        return formatCurrency.format(amount);
    }
}