package com.example.demo.lombok;

import lombok.Data;

/**
 *  @Data 注解代替get set 方法
 * @author Administrator
 */
@Data
public class User {
    private String name;
    private Integer age;
    private String sex;
}
