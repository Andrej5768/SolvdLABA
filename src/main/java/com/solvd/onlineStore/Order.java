package com.solvd.onlineStore;

import java.util.Date;

public class Order {
    private Date date;

    private Cart cart;

    private long totalPrice;

    private String status;

    private String commits;

    public Order() {
    }

    public Order(Date date, Cart cart, long totalPrice, String status, String commits) {
        this.date = date;
        this.cart = cart;
        this.totalPrice = totalPrice;
        this.status = status;
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
