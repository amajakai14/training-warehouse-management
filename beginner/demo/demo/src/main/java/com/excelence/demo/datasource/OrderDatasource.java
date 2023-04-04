package com.excelence.demo.datasource;

import com.excelence.demo.model.ExampleOrder;
import com.excelence.demo.model.OrderStatus;
import com.excelence.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Repository
public class OrderDatasource implements OrderRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void insertOrder(ExampleOrder order) {
        ExampleOrderEntity entity = ExampleOrderEntity.of(order);
        create(entity);
    }

    private void create(ExampleOrderEntity entity) {
            String sql = "INSERT INTO example_order(item_id, name, amount, order_status, order_date) VALUES (?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, entity.itemId, entity.name, entity.amount, entity.orderStatus.name(), entity.orderDate);
    }

    @Override
    public void updateOrder(ExampleOrder order) {
        ExampleOrderEntity entity = ExampleOrderEntity.of(order);
        //entity.update();
            String sql = "UPDATE example_order SET name = ?, amount = ?, order_status = ?, order_date = ? WHERE id = ?";
            jdbcTemplate.update(sql);

    }

    @Override
    public void deleteOrder(int id) {
        String sql = "DELETE FROM example_order WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public ExampleOrder getOrder(int id) {
        String sql = "SELECT * FROM example_order WHERE id = ?";
        List<Map<String, Object>> records = jdbcTemplate.queryForList(sql, id);
        if (records.isEmpty()) return ExampleOrder.empty();
        return toModel(records.get(0));
    }

    private ExampleOrder toModel(Map<String, Object> record) {
        Date date = (Date) record.get("order_date");
        return new ExampleOrder(
                (int) record.get("id"),
                (int) record.get("item_id"),
                (String) record.get("name"),
                (int) record.get("amount"),
                OrderStatus.valueOf((String) record.get("order_status")),
                date.toLocalDate()
        );
    }


    @Override
    public List<ExampleOrder> getAllOrder() {
        String sql = "SELECT * FROM example_order";
        List<Map<String, Object>> records = jdbcTemplate.queryForList(sql);
        return records.stream()
                .map(this::toModel)
                .collect(toList());
    }
}
