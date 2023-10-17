package com.example.controller;

import com.example.producer.KafkaProducer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @RequestMapping(value = "/send",method = RequestMethod.GET)
    @ResponseBody
    public boolean sendTopic(@RequestParam String str){
        kafkaProducer.send(str);
        return true;
    }

}
