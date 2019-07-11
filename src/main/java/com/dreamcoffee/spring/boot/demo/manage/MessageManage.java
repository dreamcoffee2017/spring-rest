//package com.dreamcoffee.spring.boot.demo.manage;
//
//import com.dreamcoffee.spring.boot.demo.Application;
//import com.dreamcoffee.spring.boot.demo.listener.CustomerAddMessageListener;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.SpringApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.listener.PatternTopic;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
//import org.springframework.stereotype.Component;
//
///**
// * MessageManage
// *
// * @author Administrator
// * @date 2019/6/26
// */
//@Component
//public class MessageManage {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(MessageManage.class);
//
//    @Bean
//    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {
//        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.addMessageListener(
//                new MessageListenerAdapter(new CustomerAddMessageListener()),
//                new PatternTopic("customer-add"));
//        return container;
//    }
//
//    @Bean
//    StringRedisTemplate stringRedisTemplate(RedisConnectionFactory connectionFactory) {
//        return new StringRedisTemplate(connectionFactory);
//    }
//
//    public static void main(String[] args) {
//        ApplicationContext ctx = SpringApplication.run(Application.class, args);
//        StringRedisTemplate stringRedisTemplate = ctx.getBean(StringRedisTemplate.class);
//        LOGGER.info("Sending message...");
//        stringRedisTemplate.convertAndSend("customer-add", "Hello from Redis!");
//        System.exit(0);
//    }
//}
