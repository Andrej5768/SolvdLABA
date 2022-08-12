package com.solvd.onlineStore.exeption;

public class InvalidWithdrawal extends IllegalArgumentException {

    public InvalidWithdrawal() {
        super("Amount more then current balance");
    }
}
