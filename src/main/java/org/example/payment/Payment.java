package org.example.payment;

import java.math.BigDecimal;

public interface Payment {
    boolean pay(BigDecimal totalMoney);
}
