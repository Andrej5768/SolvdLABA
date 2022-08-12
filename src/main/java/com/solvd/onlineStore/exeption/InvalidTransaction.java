package com.solvd.onlineStore.exeption;

public class InvalidTransaction extends IllegalArgumentException {

    public InvalidTransaction() {
        super("Not enough money to buy");
    }
}
