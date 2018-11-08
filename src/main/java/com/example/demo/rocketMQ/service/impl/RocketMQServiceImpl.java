package com.example.demo.rocketMQ.service.impl;

import com.example.demo.rocketMQ.rocket.RocketMQProvider;
import com.example.demo.rocketMQ.service.RocketMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RocketMQServiceImpl implements RocketMQService{
    @Autowired
    private RocketMQProvider mqProvider;

    @Override
    public String sendMsg(String msg) {
        return mqProvider.produc(msg, 123);
    }
}
