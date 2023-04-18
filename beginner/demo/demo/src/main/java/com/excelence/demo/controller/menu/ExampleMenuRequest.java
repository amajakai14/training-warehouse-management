package com.excelence.demo.controller.menu;

import com.excelence.demo.model.ExampleMenu;

public class ExampleMenuRequest {
    public String name;

    public ExampleMenu toMenu() {
        return new ExampleMenu(0, name);
    }

    public ExampleMenuRequest() {
        this.name = null;
    }
}
