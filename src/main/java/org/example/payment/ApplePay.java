package org.example.payment;

import java.math.BigDecimal;

public class ApplePay implements Payment {
    @Override
    public boolean pay(BigDecimal totalMoney) {
        System.out.println("You should pay: " + totalMoney + " with Apple pay");
        return true;
    }
}
