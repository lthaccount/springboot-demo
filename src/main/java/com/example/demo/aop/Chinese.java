package com.example.demo.aop;

import org.springframework.stereotype.Service;

@Service
public class Chinese implements IHuman {
    @Override
    public void eat() {
        System.out.println("中国人吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("中国人睡觉");
    }
}
