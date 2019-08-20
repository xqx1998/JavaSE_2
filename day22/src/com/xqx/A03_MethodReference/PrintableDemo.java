package com.xqx.A03_MethodReference;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/19 15:43
 * description:
 */
public class PrintableDemo {
    public static void main(String[] args) {
        System.out.println("匿名内部类实现：");
        usePrintNum(-10, new Printable() {
            @Override
            public int printNum(int num) {
                return Math.abs(num);
            }
        });

        System.out.println("lambda表达式实现：");
        usePrintNum(-10, num->Math.abs(num));

        System.out.println("方法引用实现");
        usePrintNum(-10,Math::abs);
    }

    private static void usePrintNum(int num, Printable printable){
        int printNum = printable.printNum(num);
        System.out.println(printNum);
    }
}
