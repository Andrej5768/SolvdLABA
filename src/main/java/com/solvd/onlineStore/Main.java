package com.solvd.onlineStore;

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

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        //Створюємо клієнта.
        Admin admin = UserControl.addAdmin("Admin", "admin");

        //Адмін створює двох клієнтів.
        Client client1 = admin.createClient("Petro");
        Client client2 = admin.createClient("Maria");

        //Адмін змінює пароль клієнту.
        String newPassword = admin.changeClientPassword(client1, "qwerty");

        //Адмін створює двох продавців.
        Seller seller1 = admin.createSeller("SoftMicro");
        Seller seller2 = admin.createSeller("ClothesMaster");

        //Продавець1 додає товари
        Product comp = seller1.addProduct("Super PC");
        Product soft = seller1.addProduct("Word", 5, 40);
        Product partComp = seller1.addProduct("PSU", -2, 1);
        Product mainPartComp = seller1.addProduct("Mother Board", 1, -12, Category.COMPUTERS);
        Product videocart = seller1.addProduct("RTX 3060", Category.COMPUTERS);
        Product memory = seller1.addProduct("DDR3", Category.COMPUTERS);

        //Продавець2 додає товари
        Product jeans = seller2.addProduct("Jeans", 28, 120);
        Product pullover = seller2.addProduct("PulloverPulloverPullover", 2, 100);
        Product sportSuit = seller2.addProduct("Sport suit");

        //Зміна категорії товарів
        jeans.setCategory(Category.CLOTHING);
        pullover.setCategory(Category.CLOTHING);
        sportSuit.setCategory(Category.SPORTS);
        comp.setCategory(Category.COMPUTERS);
        soft.setCategory(Category.COMPUTERS);
        partComp.setCategory(Category.COMPUTERS);

        //Зміна ціни та кількості
        seller1.changeProductPrice(comp, 1000);
        seller1.changeProductQuantity(comp, 25);

        //Поповнення гаманця клієнтом
        client1.deposit(-1000);
        client1.deposit(1000);

        //Встановлення знижки на товар
        comp.setDiscount(Discount.DISCOUNT);

        //Показ каталогу без врахування товарів з 0 ціною та кількістю
        Catalog.printCatalog();

        //Здійснення покупки (невдале)
        client1.addProductToCart(comp, 2);
        client1.buyProductInCart();

        //здійснення покупки (вдале)
        client2.deposit(5000);
        client2.addProductToCart(soft, 2);
        client2.addProductToCart(jeans, 1);
        client2.buyProductInCart();

        //
        ArrayList<Product> products = seller1.addProductsFromFile("C:/TMP/Products.txt");

        //lambda
        IToIntBiFunction<Integer, Integer> biFunction = (a, b) -> a + b;

        //thread deathlock
        Delivery delivery = new Delivery();
        Thread firstThread = new Thread(delivery, "1");
        Thread secondThread = new Thread(delivery, "2");
        firstThread.start();
        secondThread.start();
    }
}
