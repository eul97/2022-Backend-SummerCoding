package com.landvibe.homework.service;

import com.landvibe.homework.entity.User;

public interface OrderService {
    void createOrder(User user, Long menuId);

    void createOrder(User user, String menuName);

    void printOrderList(User user);

    void printOrderList();
}
