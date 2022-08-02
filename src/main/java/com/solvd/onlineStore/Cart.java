package com.solvd.onlineStore;

import java.util.HashMap;
import java.util.Objects;

public class Cart {
    private HashMap<String, Integer> productAndQuantity;


    public Cart() {
        this.productAndQuantity = new HashMap<>();
    }

    public Cart(Product product, int quantity) {
        this.productAndQuantity = new HashMap<>();
        this.productAndQuantity.put(product.getName(), quantity);
    }

    public HashMap<String, Integer> getProductAndQuantity() {
        return productAndQuantity;
    }

    public void setProductAndQuantity(HashMap<String, Integer> productAndQuantity) {
        this.productAndQuantity = productAndQuantity;
    }

    public void addProductToCart(Product product, int quantity){
        if (!productAndQuantity.containsKey(product.getName())) {
            this.productAndQuantity.putIfAbsent(product.getName(), quantity);
        } else {
            System.out.println("Product is already there");
        }
    }

    public void deleteProductInCart(Product product, int quantity){
        if (productAndQuantity.containsKey(product.getName())){
            this.productAndQuantity.remove(product.getName());
        } else {
            System.out.println("Product not found");
        }
    }

    public void addProductQuantityInCart(Product product, int quantity){
        if (productAndQuantity.containsKey(product.getName())){
            this.productAndQuantity.put(product.getName(), quantity);
        } else {
            System.out.println("Product not found");
        }
    }
}
