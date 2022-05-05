package org.example.payment;

public class PaypalPay implements Payment {
    @Override
    public boolean pay(float totalMoney) {
        System.out.println("You should pay: " + totalMoney + " with Paypal");
        return true;
    }
}
