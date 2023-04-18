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

import static java.util.stream.Collectors.toList;

@Repository
public class MenuDatasource implements MenuRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<ExampleMenu> getAllMenu() {
        String sql = "SELECT * FROM example_menu";
        List<Map<String, Object>> records = jdbcTemplate.queryForList(sql);
        return records.stream()
                .map(this::toModel)
                .collect(toList());
    }

    @Override
    public void insertMenu(ExampleMenu menu) {
        String sql = "INSERT INTO example_menu (name) VALUES (?)";
        jdbcTemplate.update(sql, menu.name());
    }

    @Override
    public ExampleMenu getMenu(int menuId) {
        String sql = "SELECT * FROM example_menu WHERE id = ?";
        Map<String, Object> record = jdbcTemplate.queryForMap(sql, menuId);
        return toModel(record);
    }

    @Override
    public void updateMenu(ExampleMenu menu) {
        String sql = "UPDATE example_menu SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, menu.name(), menu.id());
    }

    private ExampleMenu toModel(Map<String, Object> record) {
        return new ExampleMenu(
                (int) record.get("id"),
                (String) record.get("name")
        );
    }
}
