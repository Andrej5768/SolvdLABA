package com.solvd.onlineStore.exeption;

public class IncorrectPrice extends IllegalArgumentException{

    public IncorrectPrice() {
        super("Price less then 0");
    }
}
