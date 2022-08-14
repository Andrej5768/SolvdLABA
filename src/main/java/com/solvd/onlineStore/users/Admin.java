package com.solvd.onlineStore.users;

import com.solvd.onlineStore.Main;
import com.solvd.onlineStore.service.user.UserControl;
import org.apache.log4j.Logger;

public class Admin extends User {

    public static final Logger logger = Logger.getLogger(Admin.class);

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

    public String changeClientPassword(Client client, String password) {
        client.setPassword(password);
        logger.info(client.getLogin() + " change password by " + this.getLogin() + ", to \"" + password + "\"");
        return password;
    }

    public Seller createSeller(String login) {
        return UserControl.addSeller(login, "changeme");
    }

    public String changeSellerPassword(Seller seller, String password) {
        seller.setPassword(password);
        logger.info(seller.getLogin() + " change password by " + this.getLogin() + ", to \"" + password + "\"");
        return password;
    }
}
