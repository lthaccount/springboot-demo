package com.example.demo.lombok;

import lombok.Data;

/**
 *  @Data 注解代替get set 方法
 *  开发工具需要安装lombok插件来取消警告，警告也可直接无视
 * @author Administrator
 */
@Data
public class User {
    private String name;
    private Integer age;
    private String sex;
}
