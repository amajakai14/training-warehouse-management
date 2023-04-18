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

    public ExampleOrder getOrderById(int orderId) {
        return orderRepository.getOrder(orderId);
    }


    public void updateOrder(ExampleOrder order) {
        orderRepository.updateOrder(order);
    }

    public void deleteOrder(int orderId) {
        orderRepository.deleteOrder(orderId);
    }

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
