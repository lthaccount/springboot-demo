package com.example.demo.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectTest {
    /**
     * 吃饭前洗手
     * 定义一个切入点为指定包下面所有类的eat()方法，执行顺序为befor
     */
    @Before("execution(* com.example.demo.aop.*.eat(..))")
    private void beforEat(){
        System.out.println("洗手");
    }

    /**
     * 吃饭后漱口
     * 定义一个切入点为指定包下面所有类的eat()方法，执行顺序为after
     */
    @After("execution(* com.example.demo.aop.*.eat(..))")
    private void afterEat(){
        System.out.println("漱口");
    }

    /**
     * 睡觉前洗澡
     * 定义一个切入点为指定包下面所有类的sleep()方法，执行顺序为befor
     */
    @Before("execution(* com.example.demo.aop.*.sleep(..))")
    private void beforSleep(){
        System.out.println("洗澡");
    }
}
