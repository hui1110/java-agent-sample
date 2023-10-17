//package com.example.consumer;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class KafkaConsumerListener {
//
//    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerListener.class);
//
//    @KafkaListener(topics = "testTopic", groupId = "testGroup")
//    public void onMessage(String str){
//        logger.info("Receive message: " + str);
//    }
//
//}
