package com.solvd.onlineStore.users;

import com.solvd.onlineStore.WishList;
import com.solvd.onlineStore.Cart;
import com.solvd.onlineStore.Order;
import com.solvd.onlineStore.Wallet;

public class Client extends User{
    private ROLE role = ROLE.CLIENT;

    private Cart cart;

    private WishList wishList;

    private Wallet wallet;

    private Order order;

}
