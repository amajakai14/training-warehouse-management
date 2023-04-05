package com.excelence.demo.controller.order;

import com.excelence.demo.controller.order.response.OrdersResponse;
import com.excelence.demo.model.ExampleOrder;
import com.excelence.demo.model.ValidateResult;
import com.excelence.demo.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService service;

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public OrdersResponse getAll() {
        List<ExampleOrder> orders = service.getAllOrder();
        return new OrdersResponse(orders);
    }

    public OrderController(OrderService service) {
        this.service = service;
    }
}