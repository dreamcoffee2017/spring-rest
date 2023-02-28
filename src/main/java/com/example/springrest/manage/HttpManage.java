package com.example.springrest.manage;

import com.example.springrest.Application;
import com.example.springrest.common.Constant;
import com.example.springrest.customer.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * HttpManage
 *
 * @author Administrator
 * @since 2019/5/27
 */
@Component
public class HttpManage {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpManage.class);
    private final RestTemplate restTemplate;

    public HttpManage(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void createCustomer() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "John");
        restTemplate.postForObject(Constant.CREATE_API, map, String.class);
    }

    public List<Customer> listCustomer() {
        return restTemplate.exchange(Constant.LIST_API + "?name=John", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Customer>>() {
                }).getBody();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        HttpManage httpManage = ctx.getBean(HttpManage.class);
        httpManage.createCustomer();
        LOGGER.info(String.valueOf(httpManage.listCustomer()));
        System.exit(0);
    }
}
