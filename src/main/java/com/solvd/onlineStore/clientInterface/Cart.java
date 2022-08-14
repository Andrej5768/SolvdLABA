package com.solvd.onlineStore.clientInterface;

import com.solvd.onlineStore.service.product.Product;
import org.apache.log4j.Logger;

import java.util.HashMap;

public class Cart {

    public static final Logger logger = Logger.getLogger(Cart.class);

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

    public void addProductToCart(Product product, int quantity) {
        if (!productAndQuantity.containsKey(product) && product.getQuantity() >= quantity) {
            this.productAndQuantity.put(product, quantity);
        } else if (product.getQuantity() >= quantity) {
            logger.error("Product is not available in this quantity");
        } else {
            logger.error("Product is already there");
        }
    }

    public void deleteProductInCart(Product product) {
        if (productAndQuantity.containsKey(product)) {
            this.productAndQuantity.remove(product);
        } else {
            logger.error("Product not found");
        }
    }

    public void addProductQuantityInCart(Product product, int quantity) {
        if (productAndQuantity.containsKey(product)) {
            this.productAndQuantity.put(product, quantity);
        } else {
            logger.error("Product not found");
        }
    }
}
