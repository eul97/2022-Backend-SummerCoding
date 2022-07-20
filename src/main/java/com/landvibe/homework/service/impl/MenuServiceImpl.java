package com.landvibe.homework.service.impl;

import com.landvibe.homework.entity.Menu;
import com.landvibe.homework.repository.MenuRepository;
import com.landvibe.homework.service.MenuService;

import java.util.List;

public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public void createMenu(String name, int price) {
        Menu menu = new Menu(menuRepository.getCount(), name, price);
        menuRepository.save(menu);
    }

    @Override
    public void printAllMenu() {
        List<Menu> menuList = menuRepository.findAllMenu();
        for (Menu menu : menuList) {
            System.out.println(menu.toString());
        }
        System.out.println();
    }
}
