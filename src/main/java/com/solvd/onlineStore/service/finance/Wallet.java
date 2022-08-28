package com.solvd.onlineStore.service.finance;

import org.apache.log4j.Logger;
import com.solvd.onlineStore.users.User;

public class Wallet {

    private static final Logger LOGGER = Logger.getLogger(Wallet.class);

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
        LOGGER.info("Transaction: " + this.getOwner().getLogin() + " +" + money);
    }

    public void takeMoney(long money){
        this.money = this.money - money;
        LOGGER.info("Transaction: " + this.getOwner().getLogin() + " -" + money);
    }
}
