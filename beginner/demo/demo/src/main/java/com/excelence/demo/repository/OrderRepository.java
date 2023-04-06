package com.excelence.demo.repository;

import com.excelence.demo.model.ExampleOrder;

import java.util.List;

public interface OrderRepository {
    List<ExampleOrder> getAllOrder();

    void insertOrder(ExampleOrder order);
}
