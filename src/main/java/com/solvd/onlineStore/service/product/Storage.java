package com.solvd.onlineStore.service.product;

import com.solvd.onlineStore.Main;
import org.apache.log4j.Logger;

import java.util.HashMap;

public class Storage {

    public static final Logger logger = Logger.getLogger(Storage.class);

    private HashMap<Product, Integer> productQuantityOnStorage;

    public Storage() {
        this.productQuantityOnStorage = new HashMap<>();
    }

    public Storage(Product product) {
        this.productQuantityOnStorage = new HashMap<>();
        this.productQuantityOnStorage.put(product, product.getQuantity());
    }

    public void addProductToStorage(Product product) {
        if (this.productQuantityOnStorage == null)
            this.productQuantityOnStorage = new HashMap<>();
        if (!this.productQuantityOnStorage.containsKey(product)) {
            this.productQuantityOnStorage.put(product, product.getQuantity());
        } else {
            logger.error("Product is \"" + product.getName() + "\" already there");
        }
    }

    public void deleteProductInStorage(Product product) {
        if (this.productQuantityOnStorage.containsKey(product)) {
            this.productQuantityOnStorage.remove(product);
        } else {
            logger.error("Product \"" + product.getName() + "\" not found");
        }
    }

    public void changeProductQuantityInStorage(Product product) {
        this.productQuantityOnStorage.put(product, product.getQuantity());
    }
}
