package com.solvd.onlineStore.service.finance;

import java.util.Map;
import org.apache.log4j.Logger;
import com.solvd.onlineStore.exeption.InvalidDeposit;
import com.solvd.onlineStore.exeption.InvalidTransaction;
import com.solvd.onlineStore.exeption.InvalidWithdrawal;
import com.solvd.onlineStore.service.delivery.Delivery;
import com.solvd.onlineStore.service.delivery.Order;
import com.solvd.onlineStore.service.product.Product;

public class Transaction {

    private static final Logger LOGGER = Logger.getLogger(Transaction.class);

    public static void deposit(Wallet wallet, long amount) {
        try {
            if (amount <= 0) {
                throw new InvalidDeposit();
            } else {
                wallet.putMoney(amount);
                LOGGER.info(wallet.getOwner().getLogin() + " deposit wallet by " + amount
                        + " . Current balance " + wallet.getMoney());
            }
        } catch (InvalidDeposit e) {
            LOGGER.error("invalid deposit");
        }
    }

    public static void withdrawal(Wallet wallet, long amount) {
        try {
            if (amount > wallet.getMoney()) {
                throw new InvalidWithdrawal();
            } else {
                wallet.takeMoney(amount);
                LOGGER.info(wallet.getOwner().getLogin() + " withdrawal wallet by " + amount
                        + " . Current balance " + wallet.getMoney());
            }
        } catch (InvalidWithdrawal e) {
            LOGGER.error("invalid withdrawal");
        }
    }

    public static void transaction(Wallet clientWallet, Order order) {
        try {
            if (clientWallet.getMoney() >= order.getTotalPrice()) {
                for (Map.Entry<Product, Integer> product : order.getCart().getProductAndQuantity().entrySet()) {
                    product.getKey().getProductSeller().getWallet().putMoney(product.getKey().getPrice() * (long) product.getValue());
                    product.getKey().getProductSeller().changeProductQuantity(product.getKey(),
                            product.getKey().getQuantity() - product.getValue());
                }
                clientWallet.takeMoney(order.getTotalPrice());
                new Delivery(order, clientWallet.getOwner());
            } else {
                throw new InvalidTransaction();
            }
        } catch (InvalidTransaction e) {
            LOGGER.error("Not enough money to buy");
        }
    }
}
