package com.solvd.onlineStore;

import com.solvd.onlineStore.service.product.Product;
import com.solvd.onlineStore.service.user.UserControl;
import com.solvd.onlineStore.users.Admin;
import com.solvd.onlineStore.users.Client;
import com.solvd.onlineStore.users.Seller;
import org.apache.log4j.Logger;

import java.util.Date;


public class Main {
    public static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Admin admin = UserControl.addAdmin("Admin", "admin");

        Client client1 = admin.createClient("Client");

        String newPassword = admin.changeClientPassword(client1, "qwerty");
        System.out.println(newPassword);

        Seller seller1 = admin.createSeller("SoftMicro");

        Product comp = seller1.addProduct("Super PC");

        System.out.println(comp.toString());

        seller1.changeProductPrice(comp, 1000);
        seller1.changeProductQuantity(comp, 25);

        System.out.println(comp.toString());

        System.out.println(new Date());





    }
}
