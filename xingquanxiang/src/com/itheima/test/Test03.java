package com.itheima.test;

import com.itheima.domain.Money;
import com.itheima.domain.VendingMachine;

import java.io.*;
import java.util.HashMap;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/17 14:27
 * description:
 * 第三题：分析以下需求,并用代码实现（20分）
 * 	按照以下要求模拟自动收货机的售货过程
 * 	1.创建钞票类（Money）
 * 		属性：面值、真假(bolean类型)
 * 	2.创建自动售货机类(VendingMachine)
 * 		属性有机器名称、饮料列表（HashMap<String, Float>）、机内剩余现金总额（float类型）
 * 	3.在VendingMachine类中定义购买饮料的方法：
 * 		传入钞票和饮料名称后，需要判断传入的钞票是否为真、面值是否足够购买此类饮料；若不符合购买条件给出错误提示，结束购买流程；
 * 		若购买成功后需打印出找零金额和目前机内现金总额；
 * 	4.创建test类，根据以下要求完成相关功能:
 * 		(1)创建一个名为“有料饮料售货机”的售货机（VendingMachine），
 * 			给“饮料列表属性赋值并添加附件列表中的元素”（直接添加到集合即可不用IO），设置机内剩余现金总额为100.0元。
 * 		(2)调用售货机的购买饮料方法，向售货机投入10元的真币在“有料饮料售货机”成功购买一瓶脉动。
 */
public class Test03 {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine("有料饮料售货机");
        vendingMachine.setRemainingCash(100.0F);
        //创建map集合
        HashMap<String, Float> map = new HashMap<>();
        try {
            //创建字符输入流
            BufferedReader bufferedReader = new BufferedReader(new FileReader("xingquanxiang//src//com/itheima//domain//drinks.properties"));
            while (bufferedReader.ready()){
                String[] split = bufferedReader.readLine().split("=");
                map.put(split[0],Float.valueOf(split[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //给售货机上货
        vendingMachine.setDrinks(map);

        vendingMachine.buyDrink(new Money(10,true),"脉动");
    }
}
