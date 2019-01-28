package com.skanderjabouzi.intacttest.event;

import com.skanderjabouzi.intacttest.model.Product;

public class CatalogEvents {

    public static class ProductEvent {
        private String message;
        private Product product;
        public ProductEvent(String message, Product product) {
            this.message = message;
            this.product = product;
        }
        public String getMessage() {
            return message;
        }
        public Product getPrpduct() {
            return product;
        }
        public static void removeStickyEvent() {
            CatalogEvents.ProductEvent stickyEvent = GlobalBus.getBus().getStickyEvent(CatalogEvents.ProductEvent.class);
            if(stickyEvent != null) {
                GlobalBus.getBus().removeStickyEvent(stickyEvent);
            }
        }
    }
}