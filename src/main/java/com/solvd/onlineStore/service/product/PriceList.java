package com.solvd.onlineStore.service.product;

import java.util.HashMap;

public class PriceList {
    private HashMap<Product, Integer> productPrice;

    public PriceList() {
        productPrice = new HashMap<>();
    }

    public HashMap<Product, Integer> getProductPrice() {
        return productPrice;
    }

    public void addProductToPriceList(Product product) {
        if (this.productPrice == null )
            this.productPrice = new HashMap<>();
        this.productPrice.put(product, (int) product.getPrice());
    }
}
