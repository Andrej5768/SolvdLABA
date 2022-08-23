package com.solvd.onlineStore.clientInterface;

import com.solvd.onlineStore.service.product.Product;
import org.apache.log4j.Logger;

public class Comparsion {

    private static final Logger LOGGER = Logger.getLogger(Comparsion.class);

    private Product product1;

    private Product product2;

    public Comparsion() {
    }

    public Comparsion(Product product1, Product product2) {
        this.product1 = product1;
        this.product2 = product2;
    }

    public Product getProduct1() {
        return product1;
    }

    public void setProduct1(Product product1) {
        this.product1 = product1;
    }

    public Product getProduct2() {
        return product2;
    }

    public void setProduct2(Product product2) {
        this.product2 = product2;
    }

    public void compareProduct() {
        if ((product1 != null && product2 != null)) {
            compareProduct(product1, product2);
        } else {
            LOGGER.error("No product to compare");
        }
    }

    public void compareProduct(Product product1, Product product2) {
        LOGGER.info(product1.toString());
        LOGGER.info(product2.toString());
    }
}
