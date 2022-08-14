package com.solvd.onlineStore.exeption;

public class IncorrectQuantity extends IllegalArgumentException {

    public IncorrectQuantity() {
        super("Quantity less then 0");
    }
}
