package com.dreamcoffee.spring.boot.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Application
 *
 * @author Administrator
 * @date 2019/5/27
 */
@SpringBootApplication
@MapperScan("com.dreamcoffee.spring.boot.demo.*.mapper")
@EnableCaching
//@EnableScheduling
//@EnableAsync
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
