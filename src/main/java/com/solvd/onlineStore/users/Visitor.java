package com.solvd.onlineStore.users;

import com.solvd.onlineStore.clientInterface.Cart;
import com.solvd.onlineStore.service.user.UserList;

public class Visitor {

    private long visitorId;

    private Cart cart;

    public Visitor() {
        this.visitorId = UserList.getVisitorCounter();
        UserList.addVisitorCounter();
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

    public void buyProductInCart() {
        System.out.println("Please register to make a purchase");
    }
}
