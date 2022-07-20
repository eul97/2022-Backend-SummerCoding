package com.landvibe.homework;

import java.util.List;

public class Menu {
    private String name;
    private int orderNumber, price;

    public Menu(int orderNumber, String name, int price) {
        this.orderNumber = orderNumber;
        this.name = name;
        this.price = price;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
