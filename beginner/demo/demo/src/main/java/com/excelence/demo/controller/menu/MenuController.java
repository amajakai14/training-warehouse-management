package com.excelence.demo.controller.menu;

import com.excelence.demo.controller.menu.response.MenusResponse;
import com.excelence.demo.model.ExampleMenu;
import com.excelence.demo.service.MenuService;
import com.excelence.demo.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {
    private final MenuService service;

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public MenusResponse getAll() {
        List<ExampleMenu> menus = service.getAllMenu();
        return new MenusResponse(menus);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ExampleMenu menu) {
        service.createMenu(menu);
    }

    @GetMapping("/{menuId}")
    @ResponseStatus(HttpStatus.OK)
    public ExampleMenu getMenuById(@PathVariable int menuId) {
        return service.getMenuById(menuId);
    }

    @PutMapping("/{menuId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateMenu(@PathVariable int menuId, @RequestBody ExampleMenu menu) {
        service.updateMenu(menu);
    }

    public MenuController(MenuService service) {
        this.service = service;
    }
}