package com.solvd.onlineStore.users;

public class Admin extends User{

    private final int adminId;

    public static User addClient(){
        User client1 = new Client(UserList.getUserCounter());
        UserList.addUser(client1);
        return client1;
    }

    public Admin(){
        this.adminId = UserList.getAdminCounter();
        UserList.addAdminCounter();
    }

    public Admin(Account account, String login, String password) {
        super(account, login, password);
        this.adminId = UserList.getAdminCounter();
    }

    public int getAdminId() {
        return adminId;
    }
}
