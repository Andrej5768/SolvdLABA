package com.solvd.onlineStore.service.product;

import com.solvd.onlineStore.clientInterface.Catalog;
import com.solvd.onlineStore.users.Seller;

public class ProductControl {

    public static Product createProduct(String name, int quantity, long price, Storage storage, PriceList priceList, Seller seller){
        Product product = new Product(name, quantity, price);
        storage.addProductToStorage(product);
        priceList.addProductToPriceList(product);
        Catalog.addProductToCatalog(product);
        product.setSellerName(seller.getLogin());// потрібен рефрактор
        return product;
    }

    public static void changePrice(Product product, long price, PriceList priceList) {
        product.setPrice(price);
        priceList.addProductToPriceList(product);
    }

    public static void changeQuantity(Product product, int quantity, Storage storage) {
        product.setQuantity(quantity);
        storage.changeProductQuantityInStorage(product);
    }
}
