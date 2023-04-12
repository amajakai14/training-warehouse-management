package com.excelence.demo.datasource;

import com.excelence.demo.model.ExampleMenu;
import com.excelence.demo.model.ExampleOrder;
import com.excelence.demo.model.OrderStatus;
import com.excelence.demo.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Repository
public class MenuDatasource implements MenuRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //exercise to write sql query to get all menu
    @Override
    public List<ExampleMenu> getAllMenu() {
        String sql = "SELECT * FROM public.example_menu";
        List<Map<String, Object>> records = jdbcTemplate.queryForList(sql);
        return records.stream()
                .map(this::toModel)
                .collect(toList());
    }

    @Override
    public void insertMenu(ExampleMenu menu) {
        ExampleMenuEntity entity = ExampleMenuEntity.of(menu);
        String sql = "INSERT INTO example_menu(id, name) VALUES (?, ?)";
        jdbcTemplate.update(
                sql,
                entity.id,
                entity.name);
    }

    //Hint this method will convert Record Map you get from Database to Our declared Model
    private ExampleMenu toModel(Map<String, Object> record) {
        return new ExampleMenu(
                (int) record.get("id"),
                (String) record.get("name")
        );
    }
}
