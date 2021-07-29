package com.huey.learning.java.jasypt.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SqlService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("now")
    public String now() {
        return jdbcTemplate.queryForObject("SELECT NOW()", String.class);
    }

}