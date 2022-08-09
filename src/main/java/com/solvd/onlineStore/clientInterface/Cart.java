package com.solvd.onlineStore.clientInterface;

import com.solvd.onlineStore.service.product.Product;

import java.util.HashMap;

public class Cart {

    private HashMap<Product, Integer> productAndQuantity;

    public Cart() {
        this.productAndQuantity = new HashMap<>();
    }

    public Cart(Product product, int quantity) {
        this.productAndQuantity = new HashMap<>();
        this.productAndQuantity.put(product, quantity);
    }

    public HashMap<Product, Integer> getProductAndQuantity() {
        return productAndQuantity;
    }

    public void setProductAndQuantity(HashMap<Product, Integer> productAndQuantity) {
        this.productAndQuantity = productAndQuantity;
    }

    public void addProductToCart(Product product, int quantity){
        if (!productAndQuantity.containsKey(product)) {
            this.productAndQuantity.putIfAbsent(product, quantity);
        } else {
            System.out.println("Product is already there");
        }
    }

    public void deleteProductInCart(Product product, int quantity){
        if (productAndQuantity.containsKey(product)){
            this.productAndQuantity.remove(product);
        } else {
            System.out.println("Product not found");
        }
    }

    public void addProductQuantityInCart(Product product, int quantity){
        if (productAndQuantity.containsKey(product)){
            this.productAndQuantity.put(product, quantity);
        } else {
            System.out.println("Product not found");
        }
    }
}
