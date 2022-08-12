package com.solvd.onlineStore.service.product;

import com.solvd.onlineStore.Main;
import com.solvd.onlineStore.clientInterface.Catalog;
import com.solvd.onlineStore.exeption.IncorrectPrice;
import com.solvd.onlineStore.exeption.IncorrectQuantity;
import com.solvd.onlineStore.users.Seller;

import java.security.InvalidParameterException;

public class ProductControl {

    public static Product createProduct(String name, int quantity, long price, Storage storage, PriceList priceList, Seller seller){
        try {
            if (price < 0) {
                throw new IncorrectPrice();
            } else if (quantity < 0) {
                throw new IncorrectQuantity();
            }
        } catch (IncorrectQuantity e){
            Main.logger.error("Quantity \"" + name + "\" less then 0");
            quantity = 0;
        } catch (IncorrectPrice e) {
            Main.logger.error("Price \"" + name + "\" less then 0");
            price = 0;
        }
        Product product = new Product(name, quantity, price);
        storage.addProductToStorage(product);
        priceList.addProductToPriceList(product);
        Catalog.addProductToCatalog(product);
        product.setSellerName(seller);
        Main.logger.info("Product \"" + product.getName() + "\" add");
        return product;
    }

    public static void changePrice(Product product, long price, PriceList priceList) {
        if (price >= 0) {
            product.setPrice(price);
            priceList.addProductToPriceList(product);
        } else throw new IncorrectPrice();
    }

    public static void changeQuantity(Product product, int quantity, Storage storage) {
        if (quantity >= 0) {
            product.setQuantity(quantity);
            storage.changeProductQuantityInStorage(product);
        } else throw new IllegalArgumentException();
    }
}
