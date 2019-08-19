package com.xqx.A01_Buffered;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/15 9:27
 * description:
 */
public class Student {
    private String name;
    private Integer chinese;
    private Integer math;

    public Student() {
    }

    public Student(String name, Integer chinese, Integer math) {
        this.name = name;
        this.chinese = chinese;
        this.math = math;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getChinese() {
        return chinese;
    }

    public void setChinese(Integer chinese) {
        this.chinese = chinese;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getTotal(){
        return chinese+math;
    }

    @Override
    public String toString() {
        return  name + '\t'+ chinese + "\t" + math + '\t' + getTotal();
    }
}
