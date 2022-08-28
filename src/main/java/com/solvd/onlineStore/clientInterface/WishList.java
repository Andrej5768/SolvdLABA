package com.solvd.onlineStore.clientInterface;

import java.util.ArrayList;
import com.solvd.onlineStore.service.product.Product;

public class WishList {

    private ArrayList<String> wishList;

    public WishList() {
        this.wishList = new ArrayList<>();
    }

    public ArrayList<String> getWishList() {
        return wishList;
    }

    public void setWishList(ArrayList<String> wishList) {
        this.wishList = wishList;
    }

    public void addProductToWishList(Product product) {
        if (this.wishList == null)
            this.wishList = new WishList().getWishList();
        this.wishList.add(product.getName());
    }

    public void removeProductInWishList(Product product) {
        wishList.removeIf(productName -> product.getName().equals(productName));
    }
}
