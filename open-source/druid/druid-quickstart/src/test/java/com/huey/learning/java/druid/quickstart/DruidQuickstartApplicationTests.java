package com.huey.learning.java.druid.quickstart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

@SpringBootTest
class DruidQuickstartApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {

        Map<String, Object> result = jdbcTemplate.queryForMap("SELECT * FROM STUDENT WHERE STUD_ID = ?",
                new Object[]{1001});

        System.out.println("result = " + result);

    }

}
