package com.excelence.demo.controller.menu;

import com.excelence.demo.controller.menu.response.MenusResponse;
import com.excelence.demo.model.ExampleMenu;
import com.excelence.demo.service.MenuService;
import com.excelence.demo.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menus")
public class MenuController {
    private final MenuService service;

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public MenusResponse getAll() {
        return new MenusResponse(service.getAllMenu());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ExampleMenuRequest request) {
        service.createMenu(request.toMenu());
    }

    public MenuController(MenuService service) {
        this.service = service;
    }
}