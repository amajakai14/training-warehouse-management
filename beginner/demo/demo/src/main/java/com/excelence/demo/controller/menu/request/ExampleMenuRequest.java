package com.excelence.demo.controller.menu.request;

import com.excelence.demo.model.ExampleMenu;
import com.excelence.demo.model.ExampleOrder;
import com.excelence.demo.model.OrderStatus;
import com.excelence.demo.model.ValidateResult;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExampleMenuRequest {
    public final int id;
    public final String name;


    public ValidateResult validate() {
        if (id < 1) return ValidateResult.failed("id can't be less than 1");
        if (name == "") return ValidateResult.failed("name is blank");
        /*if (!OrderStatus.validOf(orderStatus))
            return ValidateResult.failed("orderStatus: PENDING, COMPLETED, CANCELLED are only allowed");*/
        return ValidateResult.success();
    }
    public ExampleMenu toExampleMenu() {
        return toExampleMenu(0);
    }

    public ExampleMenu toExampleMenu(int id) {
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //LocalDate formattedDate = LocalDate.parse(orderDate, formatter);
        return new ExampleMenu(id,name);
    }


    public ExampleMenuRequest(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
