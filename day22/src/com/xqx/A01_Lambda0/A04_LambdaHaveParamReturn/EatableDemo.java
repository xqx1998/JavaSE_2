package com.xqx.A01_Lambda0.A04_LambdaHaveParamReturn;

import java.util.Scanner;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/19 9:43
 * description:
 */
public class EatableDemo {
    public static void main(String[] args) {
        System.out.println("匿名内部类实现：");
        useStudent(new StudentAble() {
            @Override
            public int sum(int x, int y) {
                return x+y;
            }
        },10,20);

        System.out.println("lambda表达式实现");
        useStudent((int x,int y)-> { return x+y; },10 ,20);

        // 但是有多个参数的情况下，不能只省略一个
        System.out.println("lambda表达式实现 (省略参数类型)");
        useStudent((x,y)-> { return x+y; },10 ,20);

        //如果代码块的语句只有一条，可以省略大括号和分号
        //如果代码块的语句只有一条，可以省略大括号和分号，如果有return，return也要省略掉
        useStudent((x,y)-> x+y,10,20);

        //如果代码块的语句只有一条，可以省略大括号和分号
        System.out.println("请依次输入x值和y值：");
        Scanner scanner = new Scanner(System.in);
        useStudent((x,y)-> x+y,scanner.nextInt() ,scanner.nextInt());

    }


    private static void useStudent(StudentAble student, int x , int y){
        System.out.println(x+"+"+y+"="+student.sum(x,y));
    }

}
