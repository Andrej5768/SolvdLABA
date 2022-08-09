package com.solvd.onlineStore.service.delivery;

import com.solvd.onlineStore.clientInterface.Cart;
import com.solvd.onlineStore.service.product.Product;

import java.util.Date;
import java.util.Map;

public class Order {
    private Date date;

    private Cart cart;

    private long totalPrice;

    private String status;

    private String commits;

    public Order() {
    }

    public Order(Cart cart, String commits) {
        this.date = new Date();
        this.cart = cart;
        int sum = 0;
        for (Map.Entry<Product, Integer> product: cart.getProductAndQuantity().entrySet())
        {
            sum = sum + (product.getKey().getQuantity() * product.getValue());
        }
        this.totalPrice = sum;
        this.status = "Has ordered";
        this.commits = commits;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCommits() {
        return commits;
    }

    public void setCommits(String commits) {
        this.commits = commits;
    }


}