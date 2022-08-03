package com.solvd.onlineStore.service.product;

import com.solvd.onlineStore.Enums.Category;

public class Product {
    private String name;

    private String description;

    private long price;

    private int quantity;

    private Discount discount;

    private Category category;

    public Product(String name) {
        this.name = name;
    }

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

    public long getPrise() {
        return price;
    }

    public void setPrise(long prise) {
        this.price = (int) prise;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Discount getDiscount() {
        return discount;
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

    @Override
    public String toString() {
        return "Назва продукту: " + this.name + "\n" +
                     "Ціна: " + this.price +
                     " ";
    }
}
