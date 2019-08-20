package com.xqx.A01_StreamSort;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/19 18:12
 * description:
 * 创建一个Stream流，做中间操作：以电话号码升序排序
 */
public class Test {
    public static void main(String[] args) throws IOException {
        //创建变量存储数据文件相对路径
        String smallFilePath = "problemSolving\\src\\com\\xqx\\A01_StreamSort\\inputFile.txt";
       /* System.out.println("\"360825196211022750  13199211349 1962-11-02\".length() = " + "360825196211022750  13199211349 1962-11-02".length());
        System.out.println("58.6*1.0*1024*1024*1024/42/10000/10000"+"="+(58*1.0*1024*1024*1024/42/10000/10000)+"亿");*/
        //comparing实现
        //匿名内部类   按照电话号码升序
        /**
         *  public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
         *             Function<? super T, ? extends U> keyExtractor)
         *     {
         *         Objects.requireNonNull(keyExtractor);
         *         return (Comparator<T> & Serializable)
         *             (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
         *     }
         *
         *     comparing方法中有一个Function，那就new一个 Function，转化数据类型类型String ---> Long
         *     这里用电话号码作比较
         */
        Stream<String> chunks = Files.lines(Paths.get(smallFilePath)).sorted(Comparator.comparing(
                new Function<String, Long>() {
                    @Override
                    public Long apply(String s) {
                        return Long.parseLong(s.split("\t")[1]);
                    }
                }
        ));
        //lambda表达式
        Stream<String> chunks1 = Files.lines(Paths.get(smallFilePath)).sorted(Comparator.comparing(
                (String s) -> Long.parseLong(s.split("\t")[1])
        ));

        //遍历排序后的数据
        // chunks1.forEach(System.out::println);


        //匿名内部类实现   按照日期升序
        Stream<String> chunks2 = Files.lines(Paths.get(smallFilePath)).sorted(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.split("\t")[2].compareTo(o2.split("\t")[2]);
                    }
                }
        );

        //lambda表达式实现
        Stream<String> chunks3 = Files.lines(Paths.get(smallFilePath)).sorted(
                (o1,o2)-> {return o1.split("\t")[2].compareTo(o2.split("\t")[2]); });

        chunks3.forEach(System.out::println);
    }
}

/*
测试数据：
510603200107182516	17391773671	2001-07-18
440106200802212733	15923283919	2008-02-21
652323198302075412	18729654811	1983-02-07
320831200504103283	13870948928	2005-04-10
371423200010231737	13645823127	2000-10-23
350923199108301531	18182078590	1991-08-30
150207197004225923	15305723642	1970-04-22
350429200309181757	18767321094	2003-09-18
411421197101201612	18461757805	1971-01-20
130626198707255933	18698717974	1987-07-25
231281198404022125	17030226934	1984-04-02
420702201610282551	17352980369	2016-10-28
610528201012126248	15966546812	2010-12-12
610125196912141421	13785362540	1969-12-14
522636197312065563	13279147539	1973-12-06
330326198703154310	13684931416	1987-03-15
330122199110195025	15521780575	1991-10-19
140823201906143942	15617333041	2019-06-14
360825196211022750	13199211349	1962-11-02
500238200202012386	15810664642	2002-02-01
610827199008016122	18537759712	1990-08-01
510722200009186828	18814756895	2000-09-18
520623195806086873	13941080499	1958-06-08
211303199201315368	17729737845	1992-01-31
210181198911205724	13223097847	1989-11-20
371202194912303020	15017549204	1949-12-30
310120201207023965	18068487530	2012-07-02
610425200606212865	17925306510	2006-06-21
530825197909175226	15065723910	1979-09-17
632622195806086050	15487002816	1958-06-08
 */