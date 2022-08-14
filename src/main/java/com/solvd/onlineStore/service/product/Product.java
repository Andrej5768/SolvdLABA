package com.solvd.onlineStore.service.product;

import com.solvd.onlineStore.enums.Category;
import com.solvd.onlineStore.enums.Discount;
import com.solvd.onlineStore.users.Seller;

import java.util.Objects;

public class Product {

    private String name;

    private String description;

    private long price;

    private int quantity;

    private Discount discount = Discount.FULLPRICE;

    private Category category;

    private Seller productSeller;

    public Product(String name, int quantity, long price) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String name, String description, long price, int quantity, Discount discount, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = (int) price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDiscount() {
        return discount.toString();
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Seller getProductSeller() {
        return productSeller;
    }

    public void setProductSeller(Seller seller) {
        this.productSeller = seller;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\n" +
                     "Price: " + this.price + "\n" +
                     "Quantity: " + this.getQuantity() + "\n" +
                     "Seller Name: " + this.productSeller.getLogin() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price
                && quantity == product.quantity
                && Objects.equals(name, product.name)
                && Objects.equals(description, product.description)
                && discount == product.discount
                && category == product.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price, quantity, discount, category);
    }
}
