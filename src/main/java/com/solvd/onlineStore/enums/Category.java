package com.solvd.onlineStore.enums;

public enum Category {
    CLOTHING("Clothing"),
    COMPUTERS("Computers and parts"),
    HOUSEHOLDGOODS("Household goods"),
    TOOLS("Tools"),
    PETSUPPLIES("Pet supplies"),
    SPORTS("Sports");

    private String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
