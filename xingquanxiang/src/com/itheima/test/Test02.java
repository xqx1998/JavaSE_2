package com.itheima.test;

import java.util.HashMap;
import java.util.Map;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/17 14:19
 * description:
 * 第二题：分析以下需求，并用代码实现（20分）
 * 	1. 统计每个单词出现的次数
 * 	2. 有如下字符串"If you want to change your fate I think you must come to the dark horse to learn java"(用空格间隔)
 * 	3. 打印格式：
 * 		to=3
 * 		think=1
 * 		you=2
 * 		//........
 */
public class Test02 {
    public static void main(String[] args) {
        String str = "If you want to change your fate I think you must come to the dark horse to learn java";
        //切割字符串，用数组存储
        String[] words = str.split(" ");
        // 创建map集合
        HashMap<String, Integer> map = new HashMap<>();
        //遍历单词数组，统计出现次数并存储到map集合中
        for (String word : words) {
            //判断map集合中是否有key值是否存在此单词
            if (map.containsKey(word)){ //存在：取出对应value值并加1，存到map中
                int count = map.get(word);
                map.put(word,++count);
            }else { //不存在：第1次出现
                map.put(word, 1);
            }
        }
        //遍历map集合
        for (final Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
}
