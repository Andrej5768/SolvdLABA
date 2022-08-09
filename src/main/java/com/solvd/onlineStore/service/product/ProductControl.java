package com.solvd.onlineStore.service.product;

import com.solvd.onlineStore.Main;
import com.solvd.onlineStore.clientInterface.Catalog;
import com.solvd.onlineStore.users.Seller;

public class ProductControl {

    public static Product createProduct(String name, int quantity, long price, Storage storage, PriceList priceList, Seller seller){
        Product product = new Product(name, quantity, price);
        storage.addProductToStorage(product);
        priceList.addProductToPriceList(product);
        Catalog.addProductToCatalog(product);
        product.setSellerName(seller.getLogin());// потрібен рефрактор
        Main.logger.info("Product \"" + product.getName() + "\" add");
        return product;
    }

    public static void changePrice(Product product, long price, PriceList priceList) {
        try {
            if (price >= 0) {
                product.setPrice(price);
                priceList.addProductToPriceList(product);
            } else throw new IllegalArgumentException();
        } catch (IllegalArgumentException e){
            System.out.println("Price less then 0");
            Main.logger.trace("Price less then 0");
        }

    }

    public static void changeQuantity(Product product, int quantity, Storage storage) {
        try {
            if (quantity >= 0) {
                product.setQuantity(quantity);
                storage.changeProductQuantityInStorage(product);
            } else throw new IllegalArgumentException();
        } catch (IllegalArgumentException e){
            System.out.println("Quantity less then 0");
            Main.logger.trace("Quantity less then 0");
        }
    }
}
