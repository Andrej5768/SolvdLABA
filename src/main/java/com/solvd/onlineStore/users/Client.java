package com.solvd.onlineStore.users;

import com.solvd.onlineStore.WishList;
import com.solvd.onlineStore.Cart;
import com.solvd.onlineStore.Order;

public class Client extends User{
    private ROLE role = ROLE.CLIENT;

    private Cart cart;

    private WishList wishList;

    private Wallet wallet;

    private Order order;

    public Client(){}

    public Client(ROLE role, Cart cart, WishList wishList, Wallet wallet, Order order) {
        this.role = role;
        this.cart = cart;
        this.wishList = wishList;
        this.wallet = wallet;
        this.order = order;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public WishList getWishList() {
        return wishList;
    }

    public void setWishList(WishList wishList) {
        this.wishList = wishList;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
