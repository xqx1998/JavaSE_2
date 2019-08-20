package com.xqx.A04_Practice.Demo01;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/19 16:25
 * description:
 * 练习描述
 *
 *   - 定义一个接口(Converter)，里面定义一个抽象方法 int convert(String s);
 *
 *   - 定义一个测试类(ConverterDemo)，在测试类中提供两个方法
 *
 *     - 一个方法是：useConverter(Converter c)
 *
 *     - 一个方法是主方法，在主方法中调用useConverter方法
 */
public class ConverterDemo {
    public static void main(String[] args) {
        userConverter("10",new Converter(){
            @Override
            public int convert(String s) {
                return Integer.parseInt(s);
            }
        });

        userConverter("10", (s)->Integer.parseInt(s));

        userConverter("10",Integer::parseInt);


    }

    private static void userConverter(String num, Converter converter) {
        int number = converter.convert(num);
        System.out.println(num);
    }


}
