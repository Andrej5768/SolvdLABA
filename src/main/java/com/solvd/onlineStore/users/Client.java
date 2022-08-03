package com.solvd.onlineStore.users;

import com.solvd.onlineStore.clientInterface.WishList;
import com.solvd.onlineStore.clientInterface.Cart;
import com.solvd.onlineStore.service.delivery.Order;
import com.solvd.onlineStore.service.finance.Wallet;
import com.solvd.onlineStore.service.user.Account;

public class Client extends User{

    private Cart cart;

    private WishList wishList;

    private Wallet wallet;

    private Order order;

    public Client(){}

    public Client(int id) {
        super(id);
    }

    public Client(Account account, String login, String password, Cart cart, WishList wishList, Wallet wallet, Order order) {

        super(account, login, password);
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
