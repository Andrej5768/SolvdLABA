package com.solvd.onlineStore.service.product;

import java.util.HashMap;

public class Storage {
    private HashMap<Product, Integer> productQuantityOnStorage;

    public Storage() {
        this.productQuantityOnStorage = new HashMap<>();
    }

    public Storage(Product product, int count){
        this.productQuantityOnStorage = new HashMap<>();
        this.productQuantityOnStorage.put(product, count);
    }

    public void addProductToStorage(Product product, int quantity){
        if (!productQuantityOnStorage.containsKey(product)) {
            this.productQuantityOnStorage.putIfAbsent(product, quantity);
        } else {
            System.out.println("Product is already there");
        }
    }

    public void deleteProductInStorage(Product product, int quantity){
        if (productQuantityOnStorage.containsKey(product)){
            this.productQuantityOnStorage.remove(product);
        } else {
            System.out.println("Product not found");
        }
    }

    public void addProductQuantityInStorage(Product product, int quantity){
        if (productQuantityOnStorage.containsKey(product)){
            this.productQuantityOnStorage.put(product, quantity);
        } else {
            System.out.println("Product not found");
        }
    }
}
