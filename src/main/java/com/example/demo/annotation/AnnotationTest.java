package com.example.demo.annotation;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AnnotationTest {
    public AnnotationTest(){
        System.out.println("初始化");
    }

    /**
     * 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器调用一次
     *  方法执行顺序在初始化方法之后
     */
    @PostConstruct
    public void init(){
        System.out.println("init方法执行");
    }

}
