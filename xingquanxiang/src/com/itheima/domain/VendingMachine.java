package com.itheima.domain;

import java.util.HashMap;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/17 14:33
 * description:
 * 创建自动售货机类(VendingMachine)
 * 		属性有机器名称、饮料列表（HashMap<String, Float>）、机内剩余现金总额（float类型）
 * 	在VendingMachine类中定义购买饮料的方法：
 * 		传入钞票和饮料名称后，需要判断传入的钞票是否为真、面值是否足够购买此类饮料；若不符合购买条件给出错误提示，结束购买流程；
 * 		若购买成功后需打印出找零金额和目前机内现金总额；
 */
public class VendingMachine {
    private String machineName;
    private HashMap<String, Float> drinks;
    private float remainingCash;

    public VendingMachine(String machineName) {
        this.machineName = machineName;
    }

    public void buyDrink(Money money, String drinkName){
        //判断传入的钞票是否为真、面值是否足够购买此类饮料
        if (money.isFlag()||money.getValue()>=drinks.get(drinkName)){
            System.out.println("找零："+(money.getValue()-drinks.get(drinkName))+"元");
            //余额增加
            remainingCash += drinks.get(drinkName);
            System.out.println("目前机内现金总额:"+remainingCash+"元");
        }else{
            System.out.println("对不起，你传入的钞票不是真的或金额不足购买！");
        }
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public HashMap<String, Float> getDrinks() {
        return drinks;
    }

    public void setDrinks(HashMap<String, Float> drinks) {
        this.drinks = drinks;
    }

    public float getRemainingCash() {
        return remainingCash;
    }

    public void setRemainingCash(float remainingCash) {
        this.remainingCash = remainingCash;
    }

    @Override
    public String toString() {
        return "VendingMachine{" +
                "machineName='" + machineName + '\'' +
                ", drinks=" + drinks +
                ", remainingCash=" + remainingCash +
                '}';
    }
}
