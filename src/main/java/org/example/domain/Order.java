package org.example.domain;

import org.example.modual.Item;
import org.example.payment.PaymentType;

import java.math.BigDecimal;

public class Order {
    public boolean placeItems(Item[] items, String paymentType) {
        BigDecimal totalMoney = BigDecimal.ZERO;
        // You can use stream
        for (int index = 0; index < items.length; index++) {
            BigDecimal discount = BigDecimal.valueOf(items[index].getDiscount());
            BigDecimal price = items[index].getProduct().getPrice();
            BigDecimal quantity = BigDecimal.valueOf(items[index].getQuantity());
            totalMoney = totalMoney.add(price.multiply(discount).multiply(quantity));
        }
        PaymentType payload = PaymentType.findType(paymentType);
        if (payload.equals(PaymentType.Default)) {
            System.out.println("payment failed");
            return false;
        } else {
            payload.getPayment().pay(totalMoney);
            return true;
        }
    }
}
