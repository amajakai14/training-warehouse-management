package com.excelence.demo.datasource;

import com.excelence.demo.model.ExampleOrder;
import com.excelence.demo.model.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class ExampleOrderEntity {
    @Autowired
    JdbcTemplate jdbcTemplate;
    private final int id;
    private final int itemId;
    private final String name;
    private final int amount;
    private final OrderStatus orderStatus;
    private final LocalDate orderDate;

    public void create() {
        String sql = "INSERT INTO example_order(item_id, name, amount, order_status, order_date) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, itemId, name, amount, orderStatus.name(), orderDate);
    }

    public void update() {
        String sql = "UPDATE example_order SET name = ?, amount = ?, order_status = ?, order_date = ? WHERE id = ?";
        jdbcTemplate.update(sql);
    }

    public static ExampleOrderEntity of(ExampleOrder order) {
        return new ExampleOrderEntity(
            order.id(),
            order.itemId(),
            order.name(),
            order.amount(),
            order.orderStatus(),
            order.orderDate()
        );
    }

    public ExampleOrderEntity(int id, int itemId, String name, int amount, OrderStatus orderStatus, LocalDate orderDate) {
        this.id = id;
        this.itemId = itemId;
        this.name = name;
        this.amount = amount;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }
}
