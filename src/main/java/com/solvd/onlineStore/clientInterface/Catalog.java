package com.solvd.onlineStore.clientInterface;

import com.solvd.onlineStore.service.product.Product;

import java.util.ArrayList;

public class Catalog {

    private static ArrayList<String> catalog = new ArrayList<>();

    public static void addProductToCatalog(Product product) {
        String str = product.getName();



        catalog.add(str);
    }

    public static void printCatalog() {
        System.out.println("Name           | " + "Price          | " + "Quantity       | " + "Discount");
        for (int i = 0; i < catalog.size() - 1; i++) {
            for (int j = 0; j < 4; j++) {

            }
        }
    }
}
