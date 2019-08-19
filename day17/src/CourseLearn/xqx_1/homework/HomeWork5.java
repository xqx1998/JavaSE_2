package CourseLearn.xqx_1.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    练习五：Map集合的使用（四）
    五、利用Map，完成下面的功能：
    从命令行读入一个字符串，表示一个年份，输出该年的世界杯冠军是哪支球队（见后面的附件）。如果该年没有举办世界杯，则输出：没有举办世界杯。
    //tips:参阅Map接口containsKey(Object key)方法
 */
public class HomeWork5 {
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
        //从命令行读入一个字符串，表示一个年份
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = sc.nextInt();
        //判断这一年是否有世界杯，如果没有就输出"没有举办世界杯"
        /*if(map.containsKey(year)){
            //如果有举办世界杯，则获取该届世界杯冠军国家名称。
            String s = map.get(year);
            System.out.println(s);
        }else{
            System.out.println("没有举办世界杯");
        }
*/
        //直接获取该年份对应的国家，如果没有获取到，说明没有举办世界杯
        String s = map.get(year);
        System.out.println(s==null?"没有举办世界杯":s);
    }
}
