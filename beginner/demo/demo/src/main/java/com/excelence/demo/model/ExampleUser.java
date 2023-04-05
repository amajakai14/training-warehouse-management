package com.excelence.demo.model;

public class ExampleUser {
    private final int id;
    private final String name;
    private final String password;

    public int id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String password() {
        return password;
    }

    public ExampleUser changeName(String newName) {
        return new ExampleUser(id, newName, password);
    }

    public ExampleUser changePassword(String newPassword) {
        return new ExampleUser(id, name, newPassword);
    }

    public ExampleUser(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
