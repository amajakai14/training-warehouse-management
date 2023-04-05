package com.excelence.demo.model;

public class ExampleStock {
    private final int id;
    private final String name;
    private final int amount;

    public int id() {
        return id;
    }

    public String name() {
        return name;
    }

    public int amount() {
        return amount;
    }

    public ExampleStock(int id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }
}
