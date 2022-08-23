package com.solvd.onlineStore.service.product;

import com.solvd.onlineStore.clientInterface.Catalog;
import com.solvd.onlineStore.exeption.IncorrectPrice;
import com.solvd.onlineStore.exeption.IncorrectQuantity;
import com.solvd.onlineStore.interfaces.IToInteger;
import com.solvd.onlineStore.users.Seller;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ProductControl {
    private static final Logger LOGGER = Logger.getLogger(ProductControl.class);

    public static Product createProduct(String name, int quantity, long price, Storage storage, PriceList priceList, Seller seller) {
        try {
            if (price < 0) {
                throw new IncorrectPrice();
            } else if (quantity < 0) {
                throw new IncorrectQuantity();
            }
        } catch (IncorrectQuantity e) {
            LOGGER.error("Quantity \"" + name + "\" less then 0");
            quantity = 0;
        } catch (IncorrectPrice e) {
            LOGGER.error("Price \"" + name + "\" less then 0");
            price = 0;
        }
        Product product = new Product(name, quantity, price);
        storage.addProductToStorage(product);
        priceList.addProductToPriceList(product);
        Catalog.addProductToCatalog(product);
        product.setProductSeller(seller);
        LOGGER.info("Product \"" + product.getName() + "\" add");
        return product;
    }

    public static void changePrice(Product product, long price, PriceList priceList) {
        try {
            if (price >= 0) {
                product.setPrice(price);
                priceList.addProductToPriceList(product);
                LOGGER.info("Change price \"" + product.getName() + "\" to " + price);
            } else throw new IncorrectPrice();
        } catch (IncorrectPrice e) {
            LOGGER.error("Price less then 0");
        }
    }

    public static void changeQuantity(Product product, int quantity, Storage storage) {
        try {
            if (quantity >= 0) {
                product.setQuantity(quantity);
                storage.changeProductQuantityInStorage(product);
                LOGGER.info("Change quantity \"" + product.getName() + "\" to " + quantity);
            } else throw new IllegalArgumentException();
        } catch (IncorrectQuantity e) {
            LOGGER.error("Quantity less then 0");
        }
    }

    public static void deleteProduct(Product product, Seller seller) {
        seller.getStorage().deleteProductInStorage(product);
        seller.getPriceList().deleteProductInPriceList(product);
        LOGGER.info("Product \"" + product.getName() + "\" was delete");
        product = null;
    }

    public static ArrayList<Product> addProductsFromFile(Seller seller, String path) {
        try (FileInputStream fileInputStream = new FileInputStream(FileUtils.getFile(path))) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            IToInteger<String, Integer> valueConverter = x -> Integer.valueOf(x);/* lambda function */

            ArrayList<String> listProducts = new ArrayList<>();
            ArrayList<Product> productsList = new ArrayList<>();

            while (bufferedReader.ready()) {
                String str = bufferedReader.readLine();
                String[] list = str.split(",");
                if (!list[0].equals("") && list.length == 1) {
                    listProducts.add(str);
                } else if (!list[0].equals("") && list.length == 2) {
                    listProducts.add(list[0]);
                } else if (list.length == 3) {
                    Integer.parseInt(list[1]);
                    Integer.parseInt(list[2]);
                    listProducts.add(str);
                }
            }
            for (String productStr : listProducts ) {
                String[] list = productStr.split(",");
                if (list.length == 1) {
                    productsList.add(seller.addProduct(productStr));
                } else if (list.length == 3) {
                    productsList.add(seller.addProduct(list[0], valueConverter.apply(list[1]), valueConverter.apply(list[2])));
                }
            }
            return productsList;
        } catch (Exception e) {
            LOGGER.error("smth wrong with file in add");
            return null;
        }
    }
}
