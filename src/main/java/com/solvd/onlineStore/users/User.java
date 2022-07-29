package com.solvd.onlineStore.users;

public abstract class User {
    private int id;

    private String login;

    private String password;

    private ROLE role;

    public enum ROLE {
        CLIENT, ADMIN, SELLER, UNKNOWN
    }
}


