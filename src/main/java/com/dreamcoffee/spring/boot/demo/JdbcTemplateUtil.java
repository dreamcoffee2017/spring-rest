package com.dreamcoffee.spring.boot.demo;

import com.dreamcoffee.spring.boot.demo.model.GreetingDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * JdbcTemplateUtil
 *
 * @author Administrator
 * @date 2019/5/28
 */
@Component
public class JdbcTemplateUtil {

    private static final Logger logger = LoggerFactory.getLogger(JdbcTemplateUtil.class);

    @Bean
    public CommandLineRunner run(JdbcTemplate jdbcTemplate) {
        return args -> {
            logger.info("Accessing Relational Data using JDBC with Spring");
//            logger.info("Creating tables");
//            jdbcTemplate.execute("CREATE TABLE customers(id SERIAL, name VARCHAR(255), number DECIMAL(10,2))");
//            List<Object[]> argList = Stream.of("John 1", "Jeff 2.1", "Josh 3", "Josh 4")
//                    .map(o -> o.split(" "))
//                    .collect(Collectors.toList());
//            argList.forEach(o -> logger.info(String.format("Inserting customer record for %s %s", o[0], o[1])));
//            jdbcTemplate.batchUpdate("INSERT INTO customers(name, number) VALUES (?,?)", argList);
            logger.info("Querying for customer records:");
            jdbcTemplate.query("SELECT * FROM customers", new BeanPropertyRowMapper(GreetingDO.class))
                    .forEach(o -> logger.info(o.toString()));
        };
    }
}
