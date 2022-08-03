package com.solvd.onlineStore.service.user;

import com.solvd.onlineStore.users.User;

import java.util.HashMap;

public class UserList {
    private static int userCounter = 1;

    private static int adminCounter = 1;

    private static int sellerCounter = 1;

    private static long visitorCounter = 1;

    private static final HashMap<Integer, String>  userList = new HashMap<>();

    public static int getUserCounter() {
        return userCounter;
    }

    public static void addUser(User user) {
        UserList.userList.put(userCounter, user.getLogin());
        UserList.userCounter++;

    }

    public static int getAdminCounter() {
        return adminCounter;
    }

    public static void addAdminCounter() {
        UserList.adminCounter++;
    }

    public static int getSellerCounter() {
        return sellerCounter;
    }

    public static void addSellerCounter() {
        UserList.sellerCounter++;
    }

    public static long getVisitorCounter() {
        return visitorCounter;
    }

    public static void addVisitorCounter() {
        UserList.visitorCounter++;
    }

    public HashMap<Integer, String> getUserList() {
        return userList;
    }
}
