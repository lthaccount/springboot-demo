package com.example.demo.aop;

import org.springframework.stereotype.Service;

@Service
public class American implements IHuman {
    @Override
    public void eat() {
        System.out.println("美国人吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("美国人睡觉");
    }
}
