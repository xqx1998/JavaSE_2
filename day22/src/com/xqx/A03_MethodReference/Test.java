package com.xqx.A03_MethodReference;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/19 15:59
 * description:
 */
public class Test {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(sum(0,1000));
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start));
    }

    public static int sum(int m, int n){
        int sum = 0;
        if(m<0){
            for(int i = (-m)+1; i<=n;i++){
                sum += i;
            }
            return sum;
        }else{
            for(int j=m;j<=n;j++)
            sum+=j;
            return sum;
        }
    }
}
