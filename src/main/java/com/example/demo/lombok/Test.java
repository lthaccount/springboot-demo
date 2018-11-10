package com.example.demo.lombok;

public class Test {
    public static void main(String[] args) {
        User user = new User();
        user.setAge(30);
        user.setName("liyao");
        user.setSex("man");
        System.out.println(user.getAge());
    }
}
