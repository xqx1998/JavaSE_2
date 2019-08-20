package com.xqx.A01_Lambda0.A02_LambdaNoParamVoid;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/19 9:43
 * description:
 */
public class EatableDemo {
    public static void main(String[] args) {
        Eatable eatable = new EatableImpl();
        useEatable(eatable);

        useEatable(new Eatable() {
            @Override
            public void eat() {
                System.out.println("好好学习，天天向上1");
            }
        });

        useEatable(()->{
            System.out.println("好好学习，天天向上2");
        });

    }

    private static void useEatable(Eatable eatable) {
        eatable.eat();
    }

}
