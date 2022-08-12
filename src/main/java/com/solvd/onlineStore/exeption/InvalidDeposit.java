package com.solvd.onlineStore.exeption;

public class InvalidDeposit extends IllegalArgumentException {

    public InvalidDeposit() {
        super("Amount less then 1");
    }
}
