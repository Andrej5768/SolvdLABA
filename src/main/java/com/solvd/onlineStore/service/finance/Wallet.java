package com.solvd.onlineStore.service.finance;

public class Wallet {
    private long money;

    public Wallet() {}

    public Wallet(long money) {
        this.money = money;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public void putMoney(long money){
        this.money = this.money + money;
    }

    public void takeMoney(long money){
        if (this.money > money) {
            this.money = this.money - money;
        } else {
            System.out.println("You have not enought money!");
        }
    }
}
