package com.example.demo.rocketMQ.controller;

import com.example.demo.rocketMQ.service.RocketMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rocketMQ")
public class RocketMQController {
    @Autowired
    private RocketMQService rocketMQService;

    @RequestMapping(value = "sendMsg/{msg}", method = RequestMethod.GET)
    public void sendMsg(@PathVariable String msg){
        rocketMQService.sendMsg(msg);
    }
}
