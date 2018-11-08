package com.example.demo.hibernat;


import javax.persistence.*;

@Entity
@Table(name = "boot_user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private long id;
    @Column(name = "UserId", length = 32, nullable = false)
    private String userId;
    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "Sex", nullable = false)
    private String sex;
    @Column(name = "Age", nullable = false)
    private Integer age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
