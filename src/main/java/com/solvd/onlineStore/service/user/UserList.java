package com.solvd.onlineStore.service.user;

import com.solvd.onlineStore.users.User;

import java.util.HashMap;

public class UserList {
    private static int userCounter = 1;

    private static int adminCounter = 1;

    private static int sellerCounter = 1;

    private static long visitorCounter = 1;

    private static final HashMap<Integer, String>  userList = new HashMap<>();

    private static final HashMap<Integer, String>  adminList = new HashMap<>();

    private static final HashMap<Integer, String>  sellerList = new HashMap<>();

    public HashMap<Integer, String> getUserList() {
        return userList;
    }

    public HashMap<Integer, String> getAdminList() {
        return adminList;
    }

    public HashMap<Integer, String> getSellerList() {
        return sellerList;
    }

    public static int getUserCounter() {
        return userCounter;
    }

    public static int getAdminCounter() {
        return adminCounter;
    }

    public static int getSellerCounter() {
        return sellerCounter;
    }

    public static long getVisitorCounter() {
        return visitorCounter;
    }

    public static void addUser(User user) {
        userList.put(userCounter, user.getLogin());
    }

    public static void addAdmin(User user) {
        adminList.put(adminCounter, user.getLogin());
    }

    public static void addSeller(User user) {
        sellerList.put(sellerCounter, user.getLogin());
    }

    public static void addUserCounter() {
        UserList.userCounter++;
    }

    public static void addAdminCounter() {
        UserList.adminCounter++;
    }

    public static void addSellerCounter() {
        UserList.sellerCounter++;
    }

    public static void addVisitorCounter() {
        UserList.visitorCounter++;
    }
}
