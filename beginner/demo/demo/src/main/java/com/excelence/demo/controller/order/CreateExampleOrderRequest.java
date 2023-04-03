package com.excelence.demo.controller.order;

import com.excelence.demo.model.ExampleOrder;
import com.excelence.demo.model.OrderStatus;

import java.time.LocalDate;
import java.util.Arrays;

public class CreateExampleOrderRequest {
    public final int itemId;
    public final String name;
    public final int amount;
    public final String orderStatus;
    public final LocalDate orderDate;

    boolean validate() {
        return OrderStatus.validOf(orderStatus);
    }

    ExampleOrder toExampleOrder() {
        return new ExampleOrder(0, itemId, name, amount, OrderStatus.valueOf(orderStatus), orderDate);
    }

    public CreateExampleOrderRequest(int itemId, String name, int amount, String orderStatus, LocalDate orderDate) {
        this.itemId = itemId;
        this.name = name;
        this.amount = amount;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }
}
