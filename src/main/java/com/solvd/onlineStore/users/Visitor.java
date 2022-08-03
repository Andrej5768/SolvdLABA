package com.solvd.onlineStore.users;

import com.solvd.onlineStore.clientInterface.Cart;
import com.solvd.onlineStore.service.delivery.Order;
import com.solvd.onlineStore.service.user.UserList;

public class Visitor {

    private long visitorId;

    private Cart cart;

    private Order order;

    public Visitor(){}

    public Visitor(Cart cart, Order order) {
        this.visitorId = UserList.getVisitorCounter();
        UserList.addVisitorCounter();
        this.cart = cart;
        this.order = order;
    }

    public long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
