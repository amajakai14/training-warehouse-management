package com.excelence.demo.controller.menu.response;

import com.excelence.demo.model.ExampleMenu;
import com.excelence.demo.model.ExampleOrder;

import java.util.List;

public class MenusResponse {
    //TODO: Add what is needed to be return here
    public List<ExampleMenu> menus;

    public MenusResponse(List<ExampleMenu> menus) {
        this.menus = menus;
    }
}
