package com.solvd.onlineStore.service.finance;

import com.solvd.onlineStore.Main;
import com.solvd.onlineStore.exeption.InvalidDeposit;
import com.solvd.onlineStore.exeption.InvalidTransaction;
import com.solvd.onlineStore.exeption.InvalidWithdrawal;
import com.solvd.onlineStore.service.delivery.Order;
import com.solvd.onlineStore.service.product.Product;
import com.solvd.onlineStore.users.User;

import java.security.InvalidParameterException;
import java.util.Map;

public class Transaction {

    public static void deposit(Wallet wallet, long amount) {
        try {
            if (amount <= 0 ){
                throw new InvalidDeposit();
            } else {
                wallet.putMoney(amount);
                Main.logger.info(wallet.getOwner() + " deposit wallet by " + amount + " . Current balance " + wallet.getMoney());
            }
        } catch (InvalidDeposit e) {
            System.out.println("Amount less then 1");
            Main.logger.error("invalid deposit");
        }
    }

    public static void withdrawal(Wallet wallet, long amount) {
        try {
            if (amount > wallet.getMoney() ){
                throw new InvalidWithdrawal();
            } else {
                wallet.takeMoney(amount);
                Main.logger.info(wallet.getOwner().getLogin() + " withdrawal wallet by " + amount + " . Current balance " + wallet.getMoney());
            }
        } catch (InvalidWithdrawal e) {
            System.out.println("More then current balance");
            Main.logger.error("invalid withdrawal");
        }
    }

    public static void transaction(Wallet clientWallet, Order order) {
        try {
            if (clientWallet.getMoney() >= order.getTotalPrice()) {
                for (Map.Entry<Product, Integer> product : order.getCart().getProductAndQuantity().entrySet()) {
                    product.getKey().getSellerName().deposit(product.getKey().getPrice() * (long) product.getValue());
                }
            } else {
                throw new InvalidWithdrawal();
            }
        } catch (InvalidTransaction e) {
            System.out.println("Not enough money to buy");
            Main.logger.error("Not enough money to buy");
        }
    }
}
