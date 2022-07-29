package com.solvd.onlineStore.users;

import com.solvd.onlineStore.Cart;
import com.solvd.onlineStore.Order;

public class Visitor {
    private final User.ROLE role = User.ROLE.UNKNOWN;

    private int visitorId;

    private Cart cart;

    private Order order;

}
