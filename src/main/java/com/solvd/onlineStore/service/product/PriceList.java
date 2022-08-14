package com.solvd.onlineStore.service.product;

import com.solvd.onlineStore.Main;
import org.apache.log4j.Logger;

import java.util.HashMap;

public class PriceList {

    public static final Logger logger = Logger.getLogger(PriceList.class);

    private HashMap<Product, Integer> productPrice;

    public PriceList() {
        productPrice = new HashMap<>();
    }

    public HashMap<Product, Integer> getProductPriceList() {
        return productPrice;
    }

    public void addProductToPriceList(Product product) {
        if (this.productPrice == null)
            this.productPrice = new HashMap<>();
        this.productPrice.put(product, (int) product.getPrice());
    }

    public void deleteProductInPriceList(Product product) {
        if (this.productPrice.containsKey(product)) {
            this.productPrice.remove(product);
        } else {
            logger.error("Product \"" + product.getName() + "\" not found");
        }
    }
}
