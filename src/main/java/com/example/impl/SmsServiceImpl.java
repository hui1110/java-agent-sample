package com.example.impl;

import com.example.service.SmsService;

public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String message) {
        System.out.println("send message: " + message);
        return "send message: " + message;
    }

}
