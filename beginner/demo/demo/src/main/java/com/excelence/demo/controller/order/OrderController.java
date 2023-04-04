package com.excelence.demo.controller.order;

import com.excelence.demo.controller.order.CreateExampleOrderRequest;
import com.excelence.demo.controller.order.response.OrdersResponse;
import com.excelence.demo.model.ExampleOrder;
import com.excelence.demo.model.OrderStatus;
import com.excelence.demo.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

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
    public OrdersResponse getAll() {
        List<ExampleOrder> orders = service.getAllOrder();
        return new OrdersResponse(orders);
    }

    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateExampleOrderRequest create(@RequestBody CreateExampleOrderRequest request) {
        System.out.printf("Create order request: %s", request.orderDate);
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

    @DeleteMapping(value = "/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int orderId) {
        service.deleteOrder(orderId);
    }

    public OrderController(OrderService service) {
        this.service = service;
    }
}