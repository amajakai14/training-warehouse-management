package com.excelence.demo.controller.menu;

import com.excelence.demo.controller.menu.response.MenusResponse;
import com.excelence.demo.service.MenuService;
import com.excelence.demo.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menus")
public class MenuController {
    private final MenuService service;

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public MenusResponse getAll() {
        return new MenusResponse(service.getAllMenu());
    }

    public MenuController(MenuService service) {
        this.service = service;
    }
}