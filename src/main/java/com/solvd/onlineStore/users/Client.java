package com.solvd.onlineStore.users;

import com.solvd.onlineStore.AWishList;
import com.solvd.onlineStore.Cart;
import com.solvd.onlineStore.Order;
import com.solvd.onlineStore.Wallet;

public class Client extends User{
    private final ROLE role = ROLE.CLIENT;

    private Cart cart;

    private AWishList aWishList;

    private Wallet wallet;

    private Order order;

}
