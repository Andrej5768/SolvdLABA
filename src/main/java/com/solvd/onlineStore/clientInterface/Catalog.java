package com.solvd.onlineStore.clientInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.solvd.onlineStore.enums.Category;
import com.solvd.onlineStore.enums.Discount;
import com.solvd.onlineStore.service.product.Product;

public class Catalog {

    private static final Logger LOGGER = Logger.getLogger(Catalog.class);

    private static ArrayList<Product> catalog = new ArrayList<>();

    public Catalog() {
    }

    public static void addProductToCatalog(Product product) {
        catalog.add(product);
    }

    public static void printCatalog() {
        LOGGER.info("Name           | " + "Price         | " + "Quantity      | " + "Discount      | " + " Category");
        for (int i = 0; i < catalog.size() - 1; i++) {
            //Формат строки. У випадку якщо назва більше 15 символів то назва обрізається до 15 символів
            String str = String.format("%-15.15s" + "|" + "%-15s" + "|" + "%-15s" + "|" + "%-15s" + "|" + "%-15s",
                    catalog.get(i).getName(), catalog.get(i).getPrice(),
                    catalog.get(i).getQuantity(), catalog.get(i).getDiscount(), catalog.get(i).getCategory().getValue());
            if (catalog.get(i).getPrice() != 0 && catalog.get(i).getQuantity() != 0) {
                LOGGER.info(str);
            }
        }
    }

    public static void printCatalogToFile() {
        try (FileWriter fileWriter = new FileWriter("C:/TMP/catalog.txt")) {
            fileWriter.write("Name           | " + "Price         | " + "Quantity      | " + "Discount" + "\n");
            for (Product product : catalog) {
                //Формат строки. У випадку якщо назва більше 15 символів то назва обрізається до 15 символів
                fileWriter.write(String.format("%-15.15s" + "|" + "%-15s" + "|" + "%-15s" + "|" + "%-15s" + "|" + "%-15s",
                        product.getName(), product.getPrice(), product.getQuantity(),
                        product.getDiscount(), product.getCategory().getValue()) + "\n");
            }
            fileWriter.flush();
        } catch (IOException e) {
            LOGGER.error("smth wrong with file");
        }
    }

    public static void printProductWithDiscount() {
        LOGGER.info("Name           | " + "Price         | " + "Quantity      | " + "Discount      | " + " Category");
        for (int i = 0; i < catalog.size() - 1; i++) {
            //Формат строки. У випадку якщо назва більше 15 символів то назва обрізається до 15 символів
            String str = String.format("%-15.15s" + "|" + "%-15s" + "|" + "%-15s" + "|" + "%-15s" + "|" + "%-15s",
                    catalog.get(i).getName(), catalog.get(i).getPrice(),
                    catalog.get(i).getQuantity(), catalog.get(i).getDiscount(), catalog.get(i).getCategory().getValue());
            if (catalog.get(i).getPrice() != 0 && catalog.get(i).getQuantity() != 0 && catalog.get(i).getDiscount().equals(Discount.DISCOUNT.getValue())) {
                LOGGER.info(str);
            }
        }
    }

    public static void printProductByCategory(Category category) {
        LOGGER.info("Name           | " + "Price         | " + "Quantity      | " + "Discount      | " + " Category");
        for (int i = 0; i < catalog.size() - 1; i++) {
            //Формат строки. У випадку якщо назва більше 15 символів то назва обрізається до 15 символів
            String str = String.format("%-15.15s" + "|" + "%-15s" + "|" + "%-15s" + "|" + "%-15s" + "|" + "%-15s",
                    catalog.get(i).getName(), catalog.get(i).getPrice(),
                    catalog.get(i).getQuantity(), catalog.get(i).getDiscount(), catalog.get(i).getCategory().getValue());
            if (catalog.get(i).getPrice() != 0 && catalog.get(i).getQuantity() != 0 && catalog.get(i).getCategory() == category) {
                LOGGER.info(str);
            }
        }
    }
}
