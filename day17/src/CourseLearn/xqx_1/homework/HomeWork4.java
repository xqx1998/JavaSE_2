package CourseLearn.xqx_1.homework;

import java.util.*;

/*
    练习四：Map集合的使用（三）
        定义一个泛型为String类型的List集合，统计该集合中每个字符（注意，不是字符串）出现的次数。
        例如：集合中有”abc”、”bcd”两个元素，程序最终输出结果为：“a = 1,b = 2,c = 2,d = 1”。
 */
public class HomeWork4 {
    public static void main(String[] args) {
        //定义一个泛型为String类型的List集合
        List<String> list=new ArrayList<>();
        //向集合中添加字符串元素
        list.add("abc");
        list.add("bcd");
        //定义一个map集合存储字符出现的次数，Character,Integer
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        //遍历list集合，获取每一个字符串
        for (String s : list) {
            //遍历每一个字符串，获取每一个字符。
            for (int i = 0; i < s.length(); i++) {
                //获取每一个字符
                char key = s.charAt(i);
                //判断map集合中是否包含此key
                map.put(key,map.containsKey(key)?map.get(key)+1:1);
            }
        }

        //遍历map集合，打印统计次数
        Set<Character> keys = map.keySet();
        for (Character key : keys) {
            System.out.println(key+"="+map.get(key));
        }
    }
}
