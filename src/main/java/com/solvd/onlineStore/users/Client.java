package com.solvd.onlineStore.users;

import com.solvd.onlineStore.clientInterface.WishList;
import com.solvd.onlineStore.clientInterface.Cart;
import com.solvd.onlineStore.service.delivery.Order;
import com.solvd.onlineStore.service.finance.Wallet;
import com.solvd.onlineStore.service.product.Product;

public class Client extends User{

    private Cart cart = new Cart();

    private WishList wishList = new WishList();

    private Wallet wallet = new Wallet();

    private Order order;

    public Client(int id, String login, String password) {
        super(id, login, password);
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

    public String addProductToCart(Product product, int quantity) {
        this.cart.addProductToCart(product, quantity);
        return product.getName() + " : " + quantity;
    }

    public void buyProductInCart(){


    }
}
