package com.excelence.demo.controller.order;

import com.excelence.demo.controller.order.request.ExampleOrderRequest;
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

    //
    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    /*
     * @RequestBody will map the request body from client side
     * to be Any Class you want it to behave
     * in this case, it will map to ExampleOrderRequest
     * then we add a logic to validate the request if it is not valid
     * we send back an error result with status code 400 and custom message
     * @RequestBodyは、クライアント側からのリクエストボディを、任意のクラスにマッピングします。
     * この場合、ExampleOrderRequestにマッピングされます。そして、リクエストを検証するロジックを追加します。
     * もしリクエストが有効でない場合は、ステータスコード400とカスタムメッセージでエラー結果を送り返します。
     */
    public void create(@RequestBody ExampleOrderRequest request) {
        ValidateResult validate = request.validate();
        if (!validate.ok()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, validate.errorMessage());
        }
        service.createOrder(request.toExampleOrder());
    }

    public OrderController(OrderService service) {
        this.service = service;
    }
}