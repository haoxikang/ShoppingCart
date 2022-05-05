package org.example.payment;

public class AliPay implements Payment {
    @Override
    public boolean pay(float totalMoney) {
        System.out.println("You should pay: " + totalMoney + " with Ali pay");
        return true;
    }
}
