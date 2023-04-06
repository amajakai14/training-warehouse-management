package com.excelence.demo.service;

import com.excelence.demo.model.ExampleOrder;
import com.excelence.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public List<ExampleOrder> getAllOrder() {
        return orderRepository.getAllOrder();
    }


    public void createOrder(ExampleOrder order) {
        orderRepository.insertOrder(order);
    }

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
