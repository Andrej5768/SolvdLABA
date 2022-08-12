package com.solvd.onlineStore.service.finance;

import com.solvd.onlineStore.users.User;

public class Wallet {
    private long money;

    private User owner;

    public Wallet(User owner) {
        this.owner = owner;
    }

    public User getOwner() {
        return owner;
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
