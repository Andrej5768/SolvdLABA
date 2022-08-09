package com.solvd.onlineStore.users;

import com.solvd.onlineStore.service.product.PriceList;
import com.solvd.onlineStore.service.product.Product;
import com.solvd.onlineStore.service.product.ProductControl;
import com.solvd.onlineStore.service.product.Storage;
import com.solvd.onlineStore.service.finance.Wallet;

public class Seller extends User {

    private Storage storage;

    private PriceList priceList;

    private Wallet wallet;

    public Seller(int id, String login, String password) {
        super(id, login, password);
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

    public Product addProduct(String name, int quantity, long price) {
        if (this.priceList == null)
            this.priceList = new PriceList();
        if (this.storage == null)
            this.storage = new Storage();
        return ProductControl.createProduct(name, quantity, price, this.storage, this.priceList, this);
    }

    public Product addProduct(String name) {
        return addProduct(name, 0, 0);
    }

    public void changeProductPrice(Product product, long price) {
        ProductControl.changePrice(product, price, this.priceList);
    }

    public void changeProductQuantity(Product product, int quantity) {
        ProductControl.changeQuantity(product, quantity, this.storage);
    }
}
