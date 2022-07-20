package com.landvibe.homework.service.impl;

import com.landvibe.homework.entity.Menu;
import com.landvibe.homework.entity.Order;
import com.landvibe.homework.entity.User;
import com.landvibe.homework.repository.MenuRepository;
import com.landvibe.homework.repository.OrderRepository;
import com.landvibe.homework.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final MenuRepository menuRepository;

    public OrderServiceImpl(OrderRepository orderRepository, MenuRepository menuRepository) {
        this.orderRepository = orderRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public void createOrder(User user, Long menuId) {
        Menu menu = menuRepository.findById(menuId);
        makeOrder(user, menu);
    }

    @Override
    public void createOrder(User user, String menuName) {
        Menu menu = menuRepository.findByName(menuName);
        makeOrder(user, menu);
    }

    private void makeOrder(User user, Menu menu) {
        if (user.getCredit() < menu.getPrice()) {
            System.out.println("잔액이 부족해 주문에 실패하였습니다\n");
            return;
        }
        Order order = new Order(orderRepository.getCount(), menu, user);
        orderRepository.save(order);
        user.order(order);

        System.out.println("주문이 완료되었습니다\n");
    }

    @Override
    public void printOrderList(User user) {
        List<Order> orderList = user.getOrderList();
        for (Order order : orderList) {
            System.out.println(order.toString());
        }
        System.out.println();
    }

    @Override
    public void printOrderList() {
        List<Order> orderList = orderRepository.findAllOrders();
        for (Order order : orderList) {
            System.out.println(order.toString());
        }
        System.out.println();
    }
}
