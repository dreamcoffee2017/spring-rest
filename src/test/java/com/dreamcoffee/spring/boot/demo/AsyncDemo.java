package com.dreamcoffee.spring.boot.demo;

import com.dreamcoffee.spring.boot.demo.common.Constant;
import com.dreamcoffee.spring.boot.demo.manage.HttpManage;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * GitHubLookupService
 *
 * @author Administrator
 * @date 2019/7/9
 */
@Component
public class AsyncDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncDemo.class);

    @Autowired
    private HttpManage httpManage;

    @Async
    public CompletableFuture<String> findUser(String user) throws InterruptedException {
        LOGGER.info("Looking up " + user);
        Map<String, Object> jsonObject = new HashMap<>();
        jsonObject.put("name", "John");
        String result = httpManage.postJson(Constant.TEST_HTTP_URL, jsonObject);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(result);
    }

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("GithubLookup-");
        executor.initialize();
        return executor;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        AsyncDemo gitHubLookupService = ctx.getBean(AsyncDemo.class);
        long start = System.currentTimeMillis();
        CompletableFuture<String> page1 = gitHubLookupService.findUser("PivotalSoftware");
        CompletableFuture<String> page2 = gitHubLookupService.findUser("CloudFoundry");
        CompletableFuture<String> page3 = gitHubLookupService.findUser("Spring-Projects");
        // Wait until they are all done
        CompletableFuture.allOf(page1, page2, page3).join();
        LOGGER.info("Elapsed time: " + (System.currentTimeMillis() - start));
        LOGGER.info("--> " + page1.get());
        LOGGER.info("--> " + page2.get());
        LOGGER.info("--> " + page3.get());
        System.exit(0);
    }
}
