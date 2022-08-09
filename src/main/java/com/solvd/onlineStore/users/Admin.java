package com.solvd.onlineStore.users;

import com.solvd.onlineStore.service.user.UserControl;

public class Admin extends User {

    private String adminPassword;

    public Admin(int id, String login, String password) {
        super(id, login, password);
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public Client createClient(String login) {
        return UserControl.addClient(login, "changeme");
    }

    public void changeClientPassword(Client client, String password) {
        client.setPassword(password);//передать клієнту
        System.out.println("Password changed successfully" + "\n");
    }

    public Seller createSeller(String login) {
        return UserControl.addSeller(login, "changeme");
    }

    public void changeSellerPassword(Seller seller, String password) {
        seller.setPassword(password);
        System.out.println("Password changed successfully" + "\n");
    }
}
