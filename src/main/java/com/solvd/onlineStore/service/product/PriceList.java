package com.solvd.onlineStore.service.product;

import java.util.HashMap;
import org.apache.log4j.Logger;

public class PriceList {

    private static final Logger LOGGER = Logger.getLogger(PriceList.class);

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
            LOGGER.error("Product \"" + product.getName() + "\" not found");
        }
    }
}
