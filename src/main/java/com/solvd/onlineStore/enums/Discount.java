package com.solvd.onlineStore.enums;

public enum Discount {
    DISCOUNT("with discount"),
    FULLPRICE("full price");

    private String discount;

    Discount(String discount) {
        this.discount = discount;
    }

    public String getValue() {
        return discount;
    }
}
