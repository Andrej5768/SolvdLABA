package com.solvd.onlineStore;

import com.solvd.onlineStore.service.product.Product;
import com.solvd.onlineStore.service.user.Account;
import com.solvd.onlineStore.service.user.UserControl;
import com.solvd.onlineStore.users.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {
        Admin admin = UserControl.addAdmin("Admin", "admin");

        Client client1 = admin.createClient("Client");
        System.out.println(client1.getLogin());

        admin.changeClientPassword(client1, "qwerty");


        Seller seller1 = admin.createSeller("SoftMicro");

        Product comp = seller1.addProduct("Super PC");

        System.out.println(comp.toString());

        seller1.changeProductPrice(comp, 1000);
        seller1.changeProductQuantity(comp, 25);

        System.out.println(comp.toString());



    }
}
