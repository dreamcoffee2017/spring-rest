package com.dreamcoffee.spring.boot.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * JdbcTemplateUtil
 *
 * @author Administrator
 * @date 2019/5/28
 */
@Component
public class JdbcTemplateUtil {

    private static final Logger logger = LoggerFactory.getLogger(JdbcTemplateUtil.class);

//    @Bean
    public CommandLineRunner run(JdbcTemplate jdbcTemplate) {
        return args -> {
            logger.info("Accessing Relational Data using JDBC with Spring");
//            logger.info("Creating tables");
//            jdbcTemplate.execute("CREATE TABLE customers(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
//            List<Object[]> splitUpNames = Stream.of("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long")
//                    .map(name -> name.split(" "))
//                    .collect(Collectors.toList());
//            splitUpNames.forEach(name -> logger.info(String.format("Inserting customer record for %s %s", name[0], name[1])));
//            jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);
            logger.info("Querying for customer records where first_name = 'Josh':");
            jdbcTemplate.queryForList("SELECT id FROM customers WHERE first_name = ?",
                    new Object[]{"Josh"}, String.class
            ).forEach(logger::info);
        };
    }
}
