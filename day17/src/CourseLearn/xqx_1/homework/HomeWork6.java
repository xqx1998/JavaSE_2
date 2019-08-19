package CourseLearn.xqx_1.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
    练习六：Map集合的使用（五）
    六、在原有世界杯Map 的基础上，增加如下功能： 读入一支球队的名字，输出该球队夺冠的年份列表。 
    例如，读入“巴西”，应当输出 1958 1962 1970 1994 2002 读入“荷兰”，应当输出 没有获得过世界杯 
    //tips:参阅Map接口containsValue(Object value)方法
 */
public class HomeWork6 {
    public static void main(String[] args) {
        //定义一个map集合，存储每4年世界杯国家名称
        Map<Integer, String> map = new HashMap<>();
        map.put(1930, "乌拉圭");
        map.put(1934, "意大利");
        map.put(1938, "意大利");
        map.put(1950, "乌拉圭");
        map.put(1954, "西德");
        map.put(1958, "巴西");
        map.put(1962, "巴西");
        map.put(1966, "英格兰");
        map.put(1970, "巴西");
        map.put(1974, "西德");
        map.put(1978, "阿根廷");
        map.put(1982, "意大利");
        map.put(1986, "阿根廷");
        map.put(1990, "西德");
        map.put(1994, "巴西");
        map.put(1998, "法国");
        map.put(2002, "巴西");
        map.put(2006, "意大利");
        map.put(2010, "西班牙");
        map.put(2014, "德国");

        //键盘录入一个国家名称
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入国家名称：");
        String s = sc.nextLine();
        //判断map集合中的value是否包含此国家名称，如果包含，就获取所有的key，遍历map集合，找出值为该国家的key，打印出来
        if(map.containsValue(s)){
            //包含,键值对对象的方式
            Set<Map.Entry<Integer, String>> entries = map.entrySet();
            //遍历所有的entry对象
            for (Map.Entry<Integer, String> entry : entries) {
                if(entry.getValue().equals(s)){
                    System.out.print(entry.getKey()+"\t");
                }
            }
        }else{
            //如果不包含，那么就打印"没有获得过世界杯"
            System.out.println("没有获得过世界杯");
        }
    }
}
