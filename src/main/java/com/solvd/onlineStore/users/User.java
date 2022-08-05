package com.solvd.onlineStore.users;

import com.solvd.onlineStore.service.user.Account;

public abstract class User {
    private int id;

    private Account account;

    private String login;

    private String password;

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public User(int id, Account account, String login, String password) {
        this.id = id;
        this.account = account;
        this.login = login;
        this.password = password;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}


