package org.example.payment;

public class IPSPay implements Payment {
    @Override
    public boolean pay(float totalMoney) {
        System.out.println("You should pay: " + totalMoney + " with IPS");
        return true;
    }
}
