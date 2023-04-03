package com.excelence.demo.controller.order;

import com.excelence.demo.controller.order.CreateExampleOrderRequest;
import com.excelence.demo.model.ExampleOrder;
import com.excelence.demo.model.OrderStatus;
import com.excelence.demo.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService service;

    @GetMapping(value = "/{orderId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ExampleOrder get(@PathVariable int orderId) {
        return service.getOrderById(orderId);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ExampleOrder getAll() {
        ExampleOrder order = new ExampleOrder(1, 1, "test", 1, OrderStatus.PENDING, LocalDate.now());
        return order;
    }

    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateExampleOrderRequest create(@RequestBody CreateExampleOrderRequest request) {
        boolean validate = request.validate();
        if (!validate) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid order request");
        }
        service.createOrder(request.toExampleOrder());
        return request;
    }

    @PutMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CreateExampleOrderRequest update(@RequestBody CreateExampleOrderRequest request) {
        boolean validate = request.validate();
        if (!validate) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid order request");
        }
        return request;
    }

    public OrderController(OrderService service) {
        this.service = service;
    }
}