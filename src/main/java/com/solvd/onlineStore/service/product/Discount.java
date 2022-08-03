package com.solvd.onlineStore.service.product;

import java.util.HashMap;

public class Discount {
    private HashMap<Product, Integer> productWithDiscount;

    public Discount() {
    }

    public Discount(HashMap<Product, Integer> productWithDiscount) {
        this.productWithDiscount = productWithDiscount;
    }

    public HashMap<Product, Integer> getProductWithDiscount() {
        return productWithDiscount;
    }

    public void setProductWithDiscount(HashMap<Product, Integer> productWithDiscount) {
        this.productWithDiscount = productWithDiscount;
    }
}
