package com.solvd.onlineStore.clientInterface;

import com.solvd.onlineStore.service.product.Product;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Catalog {

    public Catalog() {
    }

    private static ArrayList<Product> catalog = new ArrayList<>();

    public static void addProductToCatalog(Product product) {
        catalog.add(product);
    }

    public static void printCatalog() {
        System.out.println("Name           | " + "Price         | " + "Quantity      | " + "Discount");
        for (int i = 0; i < catalog.size() - 1; i++) {
            String str = String.format("%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s",
                    catalog.get(i).getName(), catalog.get(i).getPrice(), catalog.get(i).getQuantity(), catalog.get(i).getDiscount());
            if (catalog.get(i).getPrice() != 0 && catalog.get(i).getQuantity() != 0) {
                System.out.println(str);
            }
        }
    }

    public static void printCatalogToFile() {
        File file = new File("C:/TMP/catalog.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("Name           | " + "Price         | " + "Quantity      | " + "Discount" + "\n");
            for (Product product : catalog) {
                fileWriter.write(String.format("%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s",
                        product.getName(), product.getPrice(), product.getQuantity(), product.getDiscount())  + "\n");
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("smth wrong with file");
        }
    }
}
