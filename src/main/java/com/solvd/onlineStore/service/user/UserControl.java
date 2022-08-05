package com.solvd.onlineStore.service.user;

import com.solvd.onlineStore.users.Admin;
import com.solvd.onlineStore.users.Client;
import com.solvd.onlineStore.users.Seller;
import com.solvd.onlineStore.users.User;

public class UserControl {
    public static Client addClient(String login, String password) {
        Client client = new Client(UserList.getUserCounter(), login, password);
        UserList.addUser(client);
        System.out.println("Client created successfully");
        System.out.println("Login: " + login);
        System.out.println("id: " + UserList.getUserCounter() + "\n");
        UserList.addUserCounter();
        return client;
    }

    public static Admin addAdmin(String login, String password){
        Admin admin = new Admin(UserList.getAdminCounter(), login, password);
        UserList.addAdmin(admin);
        System.out.println("Admin created successfully");
        System.out.println("Login: " + login);
        System.out.println("id: " + UserList.getAdminCounter() + "\n");
        UserList.addAdminCounter();
        return admin;
    }

    public static Seller addSeller(String login, String password){
        Seller seller = new Seller(UserList.getSellerCounter(), login, password);
        UserList.addSeller(seller);
        System.out.println("Seller created successfully");
        System.out.println("Login: " + login);
        System.out.println("id: " + UserList.getSellerCounter() + "\n");
        UserList.addSellerCounter();
        return seller;
    }


}
