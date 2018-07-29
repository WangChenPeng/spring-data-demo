package com.demo.domain;

import javax.persistence.*;

/**
 * 雇员
 */
@Entity
public class Employee {
    /**
     * 声明主键 声明主键自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 设置name的字段长度 设置可以为空,默认可以为空
     */
    @Column(length = 20,nullable = true)
    private String name;

    private Integer age;

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
