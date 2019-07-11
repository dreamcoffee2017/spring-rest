//package com.dreamcoffee.spring.boot.demo.listener;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.data.redis.connection.Message;
//import org.springframework.data.redis.connection.MessageListener;
//
///**
// * CustomerAddMessageListener
// *
// * @author Administrator
// * @date 2019/6/27
// */
//public class CustomerAddMessageListener implements MessageListener {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerAddMessageListener.class);
//
//    @Override
//    public void onMessage(Message message, byte[] bytes) {
//        LOGGER.info("Received <" + message + ">");
//    }
//}
