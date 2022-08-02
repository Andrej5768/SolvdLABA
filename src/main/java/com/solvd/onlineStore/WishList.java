package com.solvd.onlineStore;

import java.util.ArrayList;

public class WishList {
    private ArrayList<String> wishList;

    public ArrayList<String> getWishList() {
        return wishList;
    }

    public void setWishList(ArrayList<String> wishList) {
        this.wishList = wishList;
    }

    public void addProductToWishList(Product product){
        wishList.add(product.getName());
    }

    public void removeProductInWishList(Product product){
        wishList.removeIf(productName -> product.getName().equals(productName));
    }
}
