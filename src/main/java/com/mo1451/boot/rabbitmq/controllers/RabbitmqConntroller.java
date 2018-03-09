package com.mo1451.boot.rabbitmq.controllers;

import com.mo1451.boot.rabbitmq.componet.HelloSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitmqConntroller {
    @Autowired
    private HelloSender helloSender1;

    @PostMapping("/hello")
    public void hello() {
        helloSender1.send();
    }
}
