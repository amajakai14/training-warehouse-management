package com.excelence.demo.datasource;

import com.excelence.demo.model.ExampleMenu;
import com.excelence.demo.model.ExampleOrder;
import com.excelence.demo.model.OrderStatus;
import com.excelence.demo.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MenuDatasource implements MenuRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //exercise to write sql query to get all menu
    @Override
    public List<ExampleOrder> getAllOrder() {
        return null;
    }

    //Hint how to convert Record Map you get from Database to Our declared Model
    private ExampleMenu toModel(Map<String, Object> record) {
        return new ExampleMenu(
                (int) record.get("id"),
                (String) record.get("name")
        );
    }
}
