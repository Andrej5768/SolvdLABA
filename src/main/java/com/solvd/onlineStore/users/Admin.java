package com.solvd.onlineStore.users;

import com.solvd.onlineStore.service.user.Account;
import com.solvd.onlineStore.service.user.UserList;

public class Admin extends User {

    private final int adminId;

    public Admin() {
        this.adminId = UserList.getAdminCounter();
        UserList.addAdminCounter();//remove
    }

    public Admin(Account account, String login, String password) {
        super(account, login, password);
        this.adminId = UserList.getAdminCounter();
    }

    public int getAdminId() {
        return adminId;
    }

    public static User addClient() {
        User client1 = new Client(UserList.getUserCounter());
        UserList.addUser(client1);
        return client1;
    }
}
