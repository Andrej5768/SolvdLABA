package com.solvd.onlineStore.service.product;

import com.solvd.onlineStore.clientInterface.Catalog;
import com.solvd.onlineStore.exeption.IncorrectPrice;
import com.solvd.onlineStore.exeption.IncorrectQuantity;
import com.solvd.onlineStore.users.Seller;
import org.apache.log4j.Logger;

public class ProductControl {
    public static final Logger logger = Logger.getLogger(ProductControl.class);

    public static Product createProduct(String name, int quantity, long price, Storage storage, PriceList priceList, Seller seller) {
        try {
            if (price < 0) {
                throw new IncorrectPrice();
            } else if (quantity < 0) {
                throw new IncorrectQuantity();
            }
        } catch (IncorrectQuantity e) {
            logger.error("Quantity \"" + name + "\" less then 0");
            quantity = 0;
        } catch (IncorrectPrice e) {
            logger.error("Price \"" + name + "\" less then 0");
            price = 0;
        }
        Product product = new Product(name, quantity, price);
        storage.addProductToStorage(product);
        priceList.addProductToPriceList(product);
        Catalog.addProductToCatalog(product);
        product.setProductSeller(seller);
        logger.info("Product \"" + product.getName() + "\" add");
        return product;
    }

    public static void changePrice(Product product, long price, PriceList priceList) {
        try {
            if (price >= 0) {
                product.setPrice(price);
                priceList.addProductToPriceList(product);
                logger.info("Change price \"" + product.getName() + "\" to " + price);
            } else throw new IncorrectPrice();
        } catch (IncorrectPrice e) {
            logger.error("Price less then 0");
        }
    }

    public static void changeQuantity(Product product, int quantity, Storage storage) {
        try {
            if (quantity >= 0) {
                product.setQuantity(quantity);
                storage.changeProductQuantityInStorage(product);
                logger.info("Change quantity \"" + product.getName() + "\" to " + quantity);
            } else throw new IllegalArgumentException();
        } catch (IncorrectQuantity e) {
            logger.error("Quantity less then 0");
        }
    }

    public static void deleteProduct(Product product, Seller seller) {
        seller.getStorage().deleteProductInStorage(product);
        seller.getPriceList().deleteProductInPriceList(product);
        logger.info("Product \"" + product.getName() + "\" was delete");
        product = null;
    }
}
