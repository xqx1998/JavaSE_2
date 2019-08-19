package homework_day10.extendshomework_01;

import java.io.Serializable;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/15 19:57
 * description:
 */
public class Student implements Serializable {
    private static final Long serialVersionUID = 41L;
    private String name;
    private Integer age;
    private String sex;

    public Student() {
    }

    public Student(final String name, final Integer age, final String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(final String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
