package com.solvd.onlineStore;

import java.util.ArrayList;
import com.solvd.onlineStore.clientInterface.Catalog;
import com.solvd.onlineStore.enums.Category;
import com.solvd.onlineStore.enums.Discount;
import com.solvd.onlineStore.interfaces.IToIntBiFunction;
import com.solvd.onlineStore.service.delivery.Delivery;
import com.solvd.onlineStore.service.product.Product;
import com.solvd.onlineStore.service.user.UserControl;
import com.solvd.onlineStore.users.Admin;
import com.solvd.onlineStore.users.Client;
import com.solvd.onlineStore.users.Seller;

public class Main {

    public static void main(String[] args) {
        //Create admin.
        Admin admin = UserControl.addAdmin("Admin", "admin");

        //Admin create 2 clients.
        Client client1 = admin.createClient("Petro");
        Client client2 = admin.createClient("Maria");

        //Admin change password client1.
        String newPassword = admin.changeClientPassword(client1, "qwerty");

        //Admin create 2 seller.
        Seller seller1 = admin.createSeller("SoftMicro");
        Seller seller2 = admin.createSeller("ClothesMaster");

        //Seller1 add products.
        Product comp = seller1.addProduct("Super PC");
        Product soft = seller1.addProduct("Word", 5, 40);
        Product partComp = seller1.addProduct("PSU", -2, 1);
        Product mainPartComp = seller1.addProduct("Mother Board", 1, -12, Category.COMPUTERS);
        Product videocart = seller1.addProduct("RTX 3060", Category.COMPUTERS);
        Product memory = seller1.addProduct("DDR3", Category.COMPUTERS);

        //Seller2 add products.
        Product jeans = seller2.addProduct("Jeans", 28, 120);
        Product pullover = seller2.addProduct("PulloverPulloverPullover", 2, 100);
        Product sportSuit = seller2.addProduct("Sport suit");

        //Change product category.
        jeans.setCategory(Category.CLOTHING);
        pullover.setCategory(Category.CLOTHING);
        sportSuit.setCategory(Category.SPORTS);
        comp.setCategory(Category.COMPUTERS);
        soft.setCategory(Category.COMPUTERS);
        partComp.setCategory(Category.COMPUTERS);

        //Change product price and quantity.
        seller1.changeProductPrice(comp, 1000);
        seller1.changeProductQuantity(comp, 25);

        //Client1 make deposit.
        client1.deposit(-1000);
        client1.deposit(1000);

        //Set discount for product.
        comp.setDiscount(Discount.DISCOUNT);

        //Print catalog to console without products with zero price and quantity.
        Catalog.printCatalog();

        //Client1 add product to cart and buy (error).
        client1.addProductToCart(comp, 2);
        client1.buyProductInCart();

        //Client2 make deposit, add product to cart and buy (successfully).
        client2.deposit(5000);
        client2.addProductToCart(soft, 2);
        client2.addProductToCart(jeans, 1);
        client2.buyProductInCart();

        //Seller1 add product from file.
        ArrayList<Product> products = seller1.addProductsFromFile("C:/TMP/Products.txt");

        //Lambda function.
        IToIntBiFunction<Integer, Integer> biFunction = (a, b) -> a + b;

        //Thread deadlock.
        Delivery delivery = new Delivery();
        Thread firstThread = new Thread(delivery, "1");
        Thread secondThread = new Thread(delivery, "2");
        firstThread.start();
//        secondThread.start();
    }
}
