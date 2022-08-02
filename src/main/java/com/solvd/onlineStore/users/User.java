package com.solvd.onlineStore.users;

public abstract class User {
    private int id;

    private Account account;

    private String login;

    private String password;

    public User() {}

    public User(int id) {
        this.id = id;
    }

    public User(Account account, String login, String password) {
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

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}


