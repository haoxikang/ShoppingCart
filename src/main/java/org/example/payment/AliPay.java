package org.example.payment;

import java.math.BigDecimal;

public class AliPay implements Payment {
    @Override
    public boolean pay(BigDecimal totalMoney) {
        System.out.println("You should pay: " + totalMoney + " with Ali pay");
        return true;
    }
}
