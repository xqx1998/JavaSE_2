package com.xqx.A06_PropertiesIO;

import java.util.Properties;
import java.util.Set;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/15 16:30
 * description:
 * 2Properties作为Map集合的特有方法【应用】
 * 方法名 说明
 * Object setProperty(String key, String value)
 *          设置集合的键和值，都是String类型，底层调用 Hashtable方 法 put
 * String getProperty(String key)
 *          使用此属性列表中指定的键搜索属性
 * Set stringPropertyNames()
 *          从该属性列表中返回一个不可修改的键集，其中键及其对应的 值是字符串
 * 特有方
 */
public class PropertiesDemo02 {
    public static void main(String[] args) {
        //创建集合对象
        Properties properties = new Properties();

        // 存储元素
        properties.setProperty("001", "倖权祥");
        properties.setProperty("002", "张亚鑫");
        properties.setProperty("003", "何永辉");

        Set<String> stringSet = properties.stringPropertyNames();
        for (String s : stringSet) {
            System.out.println(s+","+properties.getProperty(s));
        }
    }

}
