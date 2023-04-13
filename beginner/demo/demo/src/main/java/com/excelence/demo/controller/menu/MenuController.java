package com.excelence.demo.controller.menu;

import com.excelence.demo.controller.menu.response.MenusResponse;
import com.excelence.demo.controller.menu.request.ExampleMenuRequest;
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

    /*
     * @RequestBody will map the request body from client side
     * to be Any Class you want it to behave
     * in this case, it will map to ExampleOrderRequest
     * then we add a logic to validate the request if it is not valid
     * we send back an error result with status code 400 and custom message
     */

//ここから
    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)

    public void create(@RequestBody ExampleMenuRequest request) {
        ValidateResult validate = request.validate();
        if (!validate.ok()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, validate.errorMessage());
        }
        service.CreateMenu(request.toExampleMenu());
    }
//ここまで

    public MenuController(MenuService service) {
        this.service = service;
    }
}


