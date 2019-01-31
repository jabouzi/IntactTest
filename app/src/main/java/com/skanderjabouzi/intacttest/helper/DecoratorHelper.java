package com.skanderjabouzi.intacttest.helper;

import com.skanderjabouzi.intacttest.R;
import com.skanderjabouzi.intacttest.app.CatalogApp;
import java.text.NumberFormat;
import java.util.Locale;


public class DecoratorHelper {

    private DecoratorHelper() {
        throw new IllegalStateException("Utility class");
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