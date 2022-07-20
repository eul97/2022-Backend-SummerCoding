package com.landvibe.homework;

import com.landvibe.homework.repository.MenuRepository;
import com.landvibe.homework.repository.OrderRepository;
import com.landvibe.homework.repository.UserRepository;
import com.landvibe.homework.repository.impl.MemoryMenuRepository;
import com.landvibe.homework.repository.impl.MemoryOrderRepository;
import com.landvibe.homework.repository.impl.MemoryUserRepository;
import com.landvibe.homework.service.MenuService;
import com.landvibe.homework.service.OrderService;
import com.landvibe.homework.service.UserService;
import com.landvibe.homework.service.impl.MenuServiceImpl;
import com.landvibe.homework.service.impl.OrderServiceImpl;
import com.landvibe.homework.service.impl.UserServiceImpl;

public class AppConfig {
    private final MenuRepository menuRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final MenuService menuService;
    private final OrderService orderService;
    private final UserService userService;

    public AppConfig() {
        this.menuRepository = new MemoryMenuRepository();
        this.orderRepository = new MemoryOrderRepository();
        this.userRepository = new MemoryUserRepository();
        this.menuService = new MenuServiceImpl(menuRepository);
        this.orderService = new OrderServiceImpl(orderRepository, menuRepository);
        this.userService = new UserServiceImpl(userRepository);
    }

    public MenuRepository getMenuRepository() {
        return menuRepository;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public MenuService getMenuService() {
        return menuService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public UserService getUserService() {
        return userService;
    }
}
