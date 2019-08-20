package com.xqx.A01_Lambda0.A05_LambdaPracie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/19 11:23
 * description:
 */
public class Demo1 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 5, 4);
        ArrayList<Integer> arrayList = new ArrayList<>(list);

        /*Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        System.out.println(list);*/

        Collections.sort(arrayList,(o1, o2) -> o1-o2 );
        System.out.println(list);

        //遍历
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.print(integer+"  ");
            }
        });
        System.out.println();
        //简化1
        list.forEach(i-> System.out.print(i+"  "));
        //简化2
        System.out.println();
        list.forEach(System.out::print);
    }
}
