package org.example.payment;

public class ApplePay implements Payment {
    @Override
    public boolean pay(float totalMoney) {
        System.out.println("You should pay: " + totalMoney + " with Apple pay");
        return true;
    }
}
