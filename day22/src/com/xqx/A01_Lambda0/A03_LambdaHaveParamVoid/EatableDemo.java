package com.xqx.A01_Lambda0.A03_LambdaHaveParamVoid;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/19 9:43
 * description:
 */
public class EatableDemo {
    public static void main(String[] args) {

        useStudent(new Student() {
            @Override
            public void learn(String name) {
                System.out.println(name+"，你真的很努力！");
            }
        },"xingquanxiang");

        useStudent((String name)->{
            System.out.println(name+"，你真的很努力！");
        },"xingquanxiang");

        useStudent(name-> System.out.println(name+"，你真的很努力！"),"xingquanxiang");
    }


    private static void useStudent(Student student,String name){
        student.learn(name);
    }

    private static void useStudent(Student student){
        student.learn("xing");
    }


}
