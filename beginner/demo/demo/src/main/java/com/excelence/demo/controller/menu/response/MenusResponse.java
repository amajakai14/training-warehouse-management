package com.excelence.demo.controller.menu.response;

import com.excelence.demo.model.ExampleMenu;

import java.util.List;

public class MenusResponse {
    public List<ExampleMenu> menus;

    public MenusResponse(List<ExampleMenu> menus) {
        this.menus = menus;
    }
}
