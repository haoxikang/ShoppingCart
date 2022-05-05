package org.example.domain;

import org.example.modual.Item;
import org.example.payment.PaymentType;

public class Order {
    public boolean placeItems(Item[] items, String paymentType) {
        float totalMoney = 0;
        // You can use stream
        for (int index = 0; index < items.length; index++) {
            float discount = items[index].getDiscount();
            float price = Float.parseFloat(items[index].getProduct().getPrice());
            int quantity = items[index].getQuantity();
            totalMoney += discount * price * quantity;
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
