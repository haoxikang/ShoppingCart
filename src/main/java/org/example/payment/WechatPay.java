package org.example.payment;

public class WechatPay implements Payment {
    @Override
    public boolean pay(float totalMoney) {
        System.out.println("You should pay: " + totalMoney + " with Wechat");
        return true;
    }
}
