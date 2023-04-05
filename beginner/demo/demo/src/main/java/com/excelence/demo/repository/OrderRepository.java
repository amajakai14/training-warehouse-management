package com.excelence.demo.repository;

import com.excelence.demo.model.ExampleOrder;

import java.util.List;

public interface OrderRepository {
    void insertOrder(ExampleOrder order);

    void updateOrder(ExampleOrder order);

    void deleteOrder(int id);

    ExampleOrder getOrder(int id);
    List<ExampleOrder> getAllOrder();
}
