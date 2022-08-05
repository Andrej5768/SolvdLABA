package com.solvd.onlineStore.service.product;

import java.util.HashMap;

public class Storage {
    private HashMap<Product, Integer> productQuantityOnStorage;

    public Storage() {
        this.productQuantityOnStorage = new HashMap<>();
    }

    public Storage(Product product) {
        this.productQuantityOnStorage = new HashMap<>();
        this.productQuantityOnStorage.put(product, product.getQuantity());
    }

    public void addProductToStorage(Product product) {
        if (this.productQuantityOnStorage == null){
            System.out.println("Storage is missing\n" +
                    "First create a Storage");
        } else if (!this.productQuantityOnStorage.containsKey(product)) {
            this.productQuantityOnStorage.putIfAbsent(product, product.getQuantity());
        } else {
            System.out.println("Product is already there");
        }
    }

    public void deleteProductInStorage(Product product) {
        if (this.productQuantityOnStorage.containsKey(product)) {
            this.productQuantityOnStorage.remove(product);
        } else {
            System.out.println("Product not found");
        }
    }

    public void changeProductQuantityInStorage(Product product) {
            this.productQuantityOnStorage.put(product, product.getQuantity());
    }
}
