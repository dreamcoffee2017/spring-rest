package com.dreamcoffee.spring.boot.demo.manage;

import com.dreamcoffee.spring.boot.demo.Application;
import com.dreamcoffee.spring.boot.demo.common.Constant;
import com.dreamcoffee.spring.boot.demo.customer.entity.Customer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * HttpManage
 *
 * @author Administrator
 * @date 2019/5/27
 */
@Component
public class HttpManage {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpManage.class);

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    /**
     * MultiValueMap -> application/x-www-form-urlencoded;charset=UTF-8
     * or multipart/form-data;charset=UTF-8
     *
     * @param url
     * @param args
     * @return
     */
    public String post(String url, MultiValueMap<String, Object> args) {
        return restTemplate.postForObject(url, args, String.class);
    }

    /**
     * Object -> application/json;charset=UTF-8
     *
     * @param url
     * @param args
     * @return
     */
    public String postJson(String url, Object args) {
        return restTemplate.postForObject(url, args, String.class);
    }

    /**
     * Object -> application/json;charset=UTF-8
     *
     * @param url
     * @param args
     * @param responseType
     * @return
     */
    public <T> T postJson(String url, Object args, ParameterizedTypeReference<T> responseType) {
        return restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(args), responseType).getBody();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        HttpManage httpManage = ctx.getBean(HttpManage.class);
        Map<String, Object> jsonObject = new HashMap<>();
        jsonObject.put("name", "John");
        String result = httpManage.postJson(Constant.TEST_HTTP_URL, jsonObject);
        LOGGER.info(result);
        List<Customer> res = httpManage.postJson(Constant.TEST_HTTP_URL, jsonObject,
            new ParameterizedTypeReference<List<Customer>>() {
            });
        System.out.println(res);
        System.exit(0);
    }
}
