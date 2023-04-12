package com.excelence.demo.controller.order.request;

import com.excelence.demo.model.ExampleOrder;
import com.excelence.demo.model.OrderStatus;
import com.excelence.demo.model.ValidateResult;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExampleOrderRequest {
    public final int itemId;
    public final String name;
    public final int amount;
    public final String orderStatus;
    public final String orderDate;

    /*
     Exercise
     *  add itemId validation it should be greater than 0
     *  add name validation it should not be empty
     *  orderDate should not be in the past
        itemIdの検証を追加する 0より大きい必要がある
        名前検証を追加する 空であってはならない
        orderDateは過去であってはならない
     */
    public ValidateResult validate() {//amountが１以上
        if (amount < 1) return ValidateResult.failed("amount can't be less than 1");
        if (!OrderStatus.validOf(orderStatus))
            return ValidateResult.failed("orderStatus: PENDING, COMPLETED, CANCELLED are only allowed");
        return ValidateResult.success();
    }

    public ExampleOrder toExampleOrder() {//idが０より大きい

        return toExampleOrder(0);
    }

    public ExampleOrder toExampleOrder(int id) {//日付が過去ではない
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate formattedDate = LocalDate.parse(orderDate, formatter);
        return new ExampleOrder(id, itemId, name, amount, OrderStatus.valueOf(orderStatus), formattedDate);
    }

    public ExampleOrderRequest(int itemId, String name, int amount, String orderStatus, String orderDate) {
        this.itemId = itemId;
        this.name = name;
        this.amount = amount;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }
}
