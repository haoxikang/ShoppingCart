package org.example.payment;

import java.math.BigDecimal;

public class IPSPay implements Payment {
    @Override
    public boolean pay(BigDecimal totalMoney) {
        System.out.println("You should pay: " + totalMoney + " with IPS");
        return true;
    }
}
