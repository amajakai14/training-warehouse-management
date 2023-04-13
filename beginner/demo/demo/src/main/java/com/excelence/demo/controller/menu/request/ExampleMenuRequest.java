package com.excelence.demo.controller.menu.request;

import com.excelence.demo.model.ExampleMenu;
import com.excelence.demo.model.ExampleOrder;
import com.excelence.demo.model.OrderStatus;
import com.excelence.demo.model.ValidateResult;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExampleMenuRequest {
    public final String name;

    public ValidateResult validate() {
        if (name == "") return ValidateResult.failed("name is blank");
        return ValidateResult.success();
    }

    public ExampleMenu toExampleMenu() {
        return toExampleMenu(0);
    }


    public ExampleMenu toExampleMenu(int id) {
        return new ExampleMenu(id,name);
    }


    public ExampleMenuRequest(String name) {
        this.name = name;
    }
}
