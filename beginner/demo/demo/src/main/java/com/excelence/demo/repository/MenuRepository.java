package com.excelence.demo.repository;

import com.excelence.demo.model.ExampleMenu;

import java.util.List;

public interface MenuRepository {
    List<ExampleMenu> getAllMenu();

    void insertMenu(ExampleMenu menu);

    ExampleMenu getMenu(int menuId);

    void updateMenu(ExampleMenu menu);

    void deleteMenu(int menuId);
}
