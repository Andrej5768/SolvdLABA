package com.solvd.onlineStore.users;

import com.solvd.onlineStore.service.product.PriceList;
import com.solvd.onlineStore.service.product.Product;
import com.solvd.onlineStore.service.product.Storage;
import com.solvd.onlineStore.service.finance.Wallet;
import com.solvd.onlineStore.service.user.Account;
import com.solvd.onlineStore.service.user.UserList;

public class Seller extends User{

    private final int sellerId;

    private Storage storage;

    private PriceList priceList;

    private Wallet wallet;

    public Seller(){
        this.sellerId = UserList.getSellerCounter();
        UserList.addSellerCounter();
    }

    public Seller(Account account, String login, String password, Storage storage, PriceList priceList, Wallet wallet) {
        super(account, login, password);
        this.sellerId = UserList.getSellerCounter();
        UserList.addSellerCounter();
        this.storage = storage;
        this.priceList = priceList;
        this.wallet = wallet;
    }

    public Product addProduct(String name, int quantity, long price){
        Product product = new Product(name, quantity, price);
        this.priceList = new PriceList(product, price);
        this.storage = new Storage();

        return product;
    }

    public int getSellerId() {
        return sellerId;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public PriceList getPriceList() {
        return priceList;
    }

    public void setPriceList(PriceList priceList) {
        this.priceList = priceList;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
