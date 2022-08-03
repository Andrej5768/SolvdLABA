package com.solvd.onlineStore;

import com.solvd.onlineStore.service.product.Product;
import com.solvd.onlineStore.service.user.Account;
import com.solvd.onlineStore.users.*;

public class Main {

    public static void main(String[] args) {
        User client2 = Admin.addClient();
        Account client2Account = new Account();
        client2.setAccount(client2Account);
        System.out.println(client2.getId());
        Seller seller = new Seller();
        Product product = seller.addProduct("gfgf", 10, 15);
        System.out.println(product.getName());


    }





}
