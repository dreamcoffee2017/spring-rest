package com.dreamcoffee.spring.boot.demo.manage;

import com.alibaba.fastjson.JSONObject;
import com.dreamcoffee.spring.boot.demo.Application;
import com.dreamcoffee.spring.boot.demo.common.Constant;
import com.dreamcoffee.spring.boot.demo.common.ResultDTO;
import com.dreamcoffee.spring.boot.demo.customer.entity.Customer;
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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

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
    public String post(String url, JSONObject args) {
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        for (Map.Entry<String, Object> entry : args.entrySet()) {
            param.set(entry.getKey(), entry.getValue());
        }
        return restTemplate.postForObject(url, param, String.class);
    }

    /**
     * Object -> application/json;charset=UTF-8
     *
     * @param url
     * @param args
     * @return
     */
    public String postJson(String url, JSONObject args) {
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
    public <T> T postJson(String url, JSONObject args, ParameterizedTypeReference<T> responseType) {
        return restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(args), responseType).getBody();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        HttpManage httpManage = ctx.getBean(HttpManage.class);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "John");
        String result = httpManage.postJson(Constant.TEST_HTTP_URL, jsonObject);
        LOGGER.info(result);
        ResultDTO<List<Customer>> res = httpManage.postJson(Constant.TEST_HTTP_URL, jsonObject, new ParameterizedTypeReference<>() {
        });
        System.out.println(res);
        System.exit(0);
    }

//    /**
//     * 忽略ssl
//     *
//     * @return
//     * @throws Exception
//     */
//    private HttpComponentsClientHttpRequestFactory generateHttpRequestFactory() throws Exception {
//        SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, (x509Certificates, authType) -> true).build();
//        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext, new NoopHostnameVerifier());
//        CloseableHttpClient httpClient = HttpClients.custom()
//                .setSSLSocketFactory(socketFactory)
//                .setConnectionTimeToLive(5, TimeUnit.MINUTES)
//                .build();
//        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
//        requestFactory.setHttpClient(httpClient);
//        requestFactory.setConnectTimeout(5000);
//        requestFactory.setReadTimeout(5000);
//        return requestFactory;
//    }
}
