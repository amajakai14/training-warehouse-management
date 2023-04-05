package com.excelence.demo.service;

import com.excelence.demo.model.ExampleOrder;
import com.excelence.demo.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    private final MenuRepository repository;

    public List<ExampleOrder> getAllOrder() {
        //TODO call method from repository and fix the return value
        return null;
    }

    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }
}
