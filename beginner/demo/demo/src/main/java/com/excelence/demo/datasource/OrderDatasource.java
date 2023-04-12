package com.excelence.demo.datasource;

import com.excelence.demo.model.ExampleOrder;
import com.excelence.demo.model.OrderStatus;
import com.excelence.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Repository
public class OrderDatasource implements OrderRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<ExampleOrder> getAllOrder() {
        String sql = "SELECT * FROM example_order";
        List<Map<String, Object>> records = jdbcTemplate.queryForList(sql);
        return records.stream()
                .map(this::toModel)
                .collect(toList());
    }

    /*
     *  It's a good practice to separate the logic of data from database apart from model
     *  in this case, we can just use ExampleOrder Model to represent the data
     *  but there might be the case that we design model differently from database
     *  then we can use Entity to represent the data from database
     */
    /*
    データベースからのデータのロジックをモデルとは別に分離するのは良い習慣です
    この場合、ExampleOrder Modelを使ってデータを表現すればいいのです
    しかし、データベースとは異なるモデル設計をする場合もあるのではないでしょうか
    となると、データベースからのデータを表現するためにEntityを使用することができます
    */
    @Override
    public void insertOrder(ExampleOrder order) {
        ExampleOrderEntity entity = ExampleOrderEntity.of(order);
        String sql = "INSERT INTO example_order(item_id, name, amount, order_status, order_date) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                entity.itemId,
                entity.name,
                entity.amount,
                entity.orderStatus.name(),
                entity.orderDate);
    }
    /*
     *  Without ExampleOrderEntity class we can do update like this
     *  ExampleOrderEntityクラスを使用しない場合は、次のように更新を行うことができます。
     *  jdbcTemplate.update(sql,
     *  order.itemId,
     *  order.name,
     *  order.amount,
     *  order.orderStatus.name(),
     *  order.orderDate);
     */

    /*
     *  a Helper function to Map result from database to ExampleOrder Model
     *  try play with it to understand how Map works
     *  (int) record.get("id") is called casting
     *  it's a way to convert one type to another
     *  in this case we convert Object to int
     * データベースからExampleOrder Modelに結果をMapするための
     * Helper関数 Mapの仕組みを理解するために遊んでみてください
     * (int) record.get("id") はキャスティングと呼ばれ、
     * ある型を別の型に変換する方法です。この場合、Objectをintに変換しています。
     */
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
}
