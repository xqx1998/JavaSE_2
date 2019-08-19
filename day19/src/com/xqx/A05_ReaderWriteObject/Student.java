package com.xqx.A05_ReaderWriteObject;

import java.io.Serializable;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/15 15:56
 * description:
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 31L;
    private String name;
    private Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
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
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
