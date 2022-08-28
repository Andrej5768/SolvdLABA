package com.solvd.onlineStore.service.user;

import org.apache.log4j.Logger;
import com.solvd.onlineStore.users.Admin;
import com.solvd.onlineStore.users.Client;
import com.solvd.onlineStore.users.Seller;

public class UserControl {

    private static final Logger LOGGER = Logger.getLogger(UserControl.class);

    public static Client addClient(String login, String password) {
        Client client = new Client(UserList.getUserCounter(), login, password);
        UserList.addUser(client);
        LOGGER.info("Client created successfully. Login: " + login + ". id: " + UserList.getUserCounter());
        UserList.addUserCounter();
        return client;
    }

    public static Admin addAdmin(String login, String password) {
        Admin admin = new Admin(UserList.getAdminCounter(), login, password);
        UserList.addAdmin(admin);
        LOGGER.info("Admin created successfully. Login: " + login + ". id: " + UserList.getAdminCounter());
        UserList.addAdminCounter();
        return admin;
    }

    public static Seller addSeller(String login, String password) {
        Seller seller = new Seller(UserList.getSellerCounter(), login, password);
        UserList.addSeller(seller);
        LOGGER.info("Seller created successfully. Login: " + login + ". id: " + UserList.getSellerCounter());
        UserList.addSellerCounter();
        return seller;
    }


}
