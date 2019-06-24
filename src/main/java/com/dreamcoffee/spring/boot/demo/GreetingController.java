package com.dreamcoffee.spring.boot.demo;

import com.alibaba.fastjson.JSONObject;
import com.dreamcoffee.spring.boot.demo.model.GreetingDO;
import com.dreamcoffee.spring.boot.demo.param.GreetingParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GreetingController
 *
 * @author Administrator
 * @date 2019/5/27
 */
@RestController
@RequestMapping(value = "/web")
public class GreetingController {

    private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @RequestMapping("/greeting")
    public String greeting(@RequestBody GreetingParam param) {
        logger.info("Building a RESTful Web Service");
        return "Hello World, " + param.getNumber();
    }
}
