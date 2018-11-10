package com.example.demo.controller;

import com.example.demo.entity.Apple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hellow")
public class HellowController {

//    @Autowired
//    private RestTemplateFactory restTemplateFactory;

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(value = "test1", method = RequestMethod.GET)
    public void test1(){
        System.out.println("请求test1");
//        restTemplateFactory实现了FactoryBean,applicationContext根据bean的ID获取到的实际上是getObject()方法返回的对象
//        要想获取restTemplateFactory本身这个bean,需要在bean的ID前加 & 符号
//        RestTemplate restTemplate = restTemplateFactory.getObject();
        RestTemplate restTemplate = (RestTemplate) applicationContext.getBean("restTemplateFactory");
//        Apple apple = restTemplate.getForObject("http://localhost:9099/hellow/test2/{param}", Apple.class, "123");
//        System.out.println(apple.toString());
        System.out.println(restTemplate);
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
