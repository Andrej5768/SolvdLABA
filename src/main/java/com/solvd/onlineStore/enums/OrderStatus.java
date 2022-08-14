package com.solvd.onlineStore.enums;

public enum OrderStatus {
    ORDERED("Has ordered"),
    PROGRESS("In progress"),
    COMPLITE("Has complite");

    private String value;

    OrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
