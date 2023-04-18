package com.excelence.demo.service;

import com.excelence.demo.model.ExampleMenu;
import com.excelence.demo.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    private final MenuRepository repository;

    public List<ExampleMenu> getAllMenu() {
        return repository.getAllMenu();
    }

    public void createMenu(ExampleMenu menu) {
        repository.insertMenu(menu);
    }

    public ExampleMenu getMenuById(int menuId) {
        return repository.getMenu(menuId);
    }

    public void updateMenu(ExampleMenu menu) {
        repository.updateMenu(menu);
    }

    public void deleteMenu(int menuId) {
        repository.deleteMenu(menuId);
    }

    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }
}
