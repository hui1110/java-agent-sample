package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/origin", method = RequestMethod.GET)
    public String origin() {
        return "I am the test origin method!";
    }

    @RequestMapping(value = "/originSleep", method = RequestMethod.GET)
    public String originSleep() throws InterruptedException {
        Thread.sleep(2000);
        return "I am the originSleep method!";
    }

}
