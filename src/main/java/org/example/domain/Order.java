package org.example.domain;

import org.example.modual.Item;
import org.example.payment.Payment;
import org.example.payment.PaymentType;

import java.math.BigDecimal;

public class Order {
    public void buyItems(Item[] items, PaymentType paymentType) {
        BigDecimal totalMoney = calculateTotalMoney(items);
        dealWithPayment(totalMoney, paymentType);
    }

    private BigDecimal calculateTotalMoney(Item[] items) {
        BigDecimal totalMoney = BigDecimal.ZERO;
        // You can use stream
        for (Item item : items) {
            BigDecimal discount = BigDecimal.valueOf(item.getDiscount());
            BigDecimal price = item.getProduct().getPrice();
            BigDecimal quantity = BigDecimal.valueOf(item.getQuantity());
            totalMoney = totalMoney.add(price.multiply(discount).multiply(quantity));
        }
        return totalMoney;
    }

    private void dealWithPayment(BigDecimal totalMoney, PaymentType paymentType) {
        Payment payment = PaymentFactory.newInstance(paymentType);
        payment.pay(totalMoney);
    }
}
