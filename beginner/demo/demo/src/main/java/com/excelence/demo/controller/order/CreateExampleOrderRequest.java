package com.excelence.demo.controller.order;

import com.excelence.demo.model.ExampleOrder;
import com.excelence.demo.model.OrderStatus;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class CreateExampleOrderRequest {
    public final int itemId;
    public final String name;
    public final int amount;
    public final String orderStatus;
    public final String orderDate;

    boolean validate() {
        return OrderStatus.validOf(orderStatus);
    }

    ExampleOrder toExampleOrder() {
        //String to LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate formattedDate = LocalDate.parse(orderDate, formatter);
        System.out.printf("formattedDate: %s", formattedDate);
        return new ExampleOrder(0, itemId, name, amount, OrderStatus.valueOf(orderStatus), formattedDate);
    }

    public CreateExampleOrderRequest(int itemId, String name, int amount, String orderStatus, String orderDate) {
        this.itemId = itemId;
        this.name = name;
        this.amount = amount;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }
}
