package com.solvd.onlineStore.service.product;

import java.util.HashMap;

public class PriceList {
    private HashMap<Product, Integer> productPrice;

    public PriceList() {
        this.productPrice = new HashMap<>();
    }

    public PriceList(Product product, long price) {
        this.productPrice = new HashMap<>();
        this.productPrice.put(product, (int) price);
    }

    public HashMap<Product, Integer> getProductPrice() {
        return productPrice;
    }
}
