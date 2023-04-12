package com.excelence.demo.controller.menu;

import com.excelence.demo.controller.menu.response.MenusResponse;
import com.excelence.demo.controller.order.request.ExampleOrderRequest;
import com.excelence.demo.controller.order.response.OrdersResponse;
import com.excelence.demo.model.ExampleMenu;
import com.excelence.demo.model.ValidateResult;
import com.excelence.demo.service.MenuService;
import com.excelence.demo.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {
    private final MenuService service;

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public MenusResponse getAll() {
        //TODO: call method from MenuService and fix the return value
        List<ExampleMenu> menus = service.getAllMenu();
        return new MenusResponse(menus);
    }

    public void create() {
        service.CreateMenu(ExampleMenu );
    }
    public MenuController(MenuService service) {
        this.service = service;
    }
}


