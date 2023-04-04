package com.excelence.demo.controller.order.response;

import com.excelence.demo.model.ExampleOrder;

import java.util.List;

public class OrdersResponse {
    public List<ExampleOrder> orders;

    public OrdersResponse(List<ExampleOrder> orders) {
        this.orders = orders;
    }
}
