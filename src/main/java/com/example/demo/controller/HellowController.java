package com.example.demo.controller;

import com.example.demo.entity.Apple;
import com.example.demo.rest.RestTemplateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hellow")
public class HellowController {

    @Autowired
    private RestTemplateFactory restTemplateFactory;

    @RequestMapping(value = "test1", method = RequestMethod.GET)
    public void test1(){
        System.out.println("请求test1");
        RestTemplate restTemplate = restTemplateFactory.getRestTemplate();
        Apple apple = restTemplate.getForObject("http://localhost:9099/hellow/test2/{param}", Apple.class, "123");
        System.out.println(apple.toString());
    }

    @RequestMapping(value = "test2/{param}", method = RequestMethod.GET)
    public Apple test2(@PathVariable String param){
        System.out.println("请求test2");
        System.out.println("请求参数：" + param);
        Apple apple = new Apple();
        apple.setColor("red");
        apple.setName("apple");
        return apple;
    }
}
