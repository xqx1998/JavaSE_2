package com.xqx.A06_PropertiesIO;

import java.util.Properties;
import java.util.Set;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/15 16:30
 * description:
 * Properties介绍
 * 是一个Map体系的集合类 Properties可以保存到流中或从流中加载
 * 属性列表中的每个键及其对应的值都是一个字符串
 */
public class PropertiesDemo01 {
    public static void main(String[] args) {
        //创建集合对象
        Properties properties = new Properties();

        // 存储元素
        properties.put("001", "倖权祥");
        properties.put("002", "张亚鑫");
        properties.put("002", "何永辉");

        // 遍历集合
        Set<Object> keySet = properties.keySet();
        for (Object o : keySet) {
            System.out.println(o+","+properties.get(o));
        }
    }

}
