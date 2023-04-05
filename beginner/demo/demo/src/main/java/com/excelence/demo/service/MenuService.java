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

    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }
}
