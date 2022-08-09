package com.solvd.onlineStore.service.user;

import com.solvd.onlineStore.Main;
import com.solvd.onlineStore.users.Admin;
import com.solvd.onlineStore.users.Client;
import com.solvd.onlineStore.users.Seller;

public class UserControl {
    public static Client addClient(String login, String password) {
        Client client = new Client(UserList.getUserCounter(), login, password);
        UserList.addUser(client);
        String str = "Client created successfully. Login: " + login + ". id: " + UserList.getUserCounter();
        Main.logger.info(str);
        UserList.addUserCounter();
        return client;
    }

    public static Admin addAdmin(String login, String password){
        Admin admin = new Admin(UserList.getAdminCounter(), login, password);
        UserList.addAdmin(admin);
        String str = "Admin created successfully. Login: " + login + ". id: " + UserList.getAdminCounter();
        Main.logger.info(str);
        UserList.addAdminCounter();
        return admin;
    }

    public static Seller addSeller(String login, String password){
        Seller seller = new Seller(UserList.getSellerCounter(), login, password);
        UserList.addSeller(seller);
        String str = "Seller created successfully. Login: " + login + ". id: " + UserList.getSellerCounter();
        Main.logger.info(str);
        UserList.addSellerCounter();
        return seller;
    }


}
