package com.dreamcoffee.spring.boot.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * JdbcTemplateDemo
 *
 * @author Administrator
 * @date 2019/5/28
 */
public class JdbcTemplateDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcTemplateDemo.class);

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        jdbcTemplate.execute("CREATE TABLE customer(id SERIAL, name VARCHAR(255), number DECIMAL(10,2))");
        List<Object[]> argList = Stream.of("John 1", "Jeff 2.1", "Josh 3", "Josh 4")
                .map(o -> o.split(" "))
                .collect(Collectors.toList());
        argList.forEach(o -> LOGGER.info(String.format("Inserting customer record for %s %s", o[0], o[1])));
        jdbcTemplate.batchUpdate("INSERT INTO customer(name, number) VALUES (?,?)", argList);
        System.exit(0);
    }
}
