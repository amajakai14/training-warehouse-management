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
    public void create(@RequestBody ExampleMenuRequest request) {
        service.createMenu(request.toMenu());
    }

    @GetMapping("/{menuId}")
    @ResponseStatus(HttpStatus.OK)
    public ExampleMenu getMenuById(@PathVariable int menuId) {
        return service.getMenuById(menuId);
    }

    @PutMapping("/{menuId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateMenu(@PathVariable int menuId, @RequestBody ExampleMenuRequest request) {
        service.updateMenu(request.toMenu());
    }

    @DeleteMapping("/{menuId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMenu(@PathVariable int menuId) {
        service.deleteMenu(menuId);
    }

    public MenuController(MenuService service) {
        this.service = service;
    }
}