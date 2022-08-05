package com.solvd.onlineStore.service.product;

import java.util.HashMap;

public class DiscountList {
    private HashMap<Product, Integer> productWithDiscount;

    public DiscountList() {
    }

    public DiscountList(HashMap<Product, Integer> productWithDiscount) {
        this.productWithDiscount = productWithDiscount;
    }

    public HashMap<Product, Integer> getProductWithDiscount() {
        return productWithDiscount;
    }

    public void setProductWithDiscount(HashMap<Product, Integer> productWithDiscount) {
        this.productWithDiscount = productWithDiscount;
    }
}
