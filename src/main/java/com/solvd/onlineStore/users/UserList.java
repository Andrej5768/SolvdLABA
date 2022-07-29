package com.solvd.onlineStore.users;

import java.util.ArrayList;

public class UserList {
    private ArrayList<User> userList = new ArrayList<>();

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void addUserToList(User user){
        this.userList.add(user);

    }

    public void removeUser(User user){
        System.out.println("User " + user.getLogin() + " with ID" + user.getId() + " delete");
        userList.removeIf(user1 -> user1.equals(user));
    }
}
