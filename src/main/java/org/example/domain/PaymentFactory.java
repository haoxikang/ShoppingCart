package org.example.domain;

import org.example.payment.*;

public class PaymentFactory {
    public static Payment newInstance(PaymentType paymentType) {
        switch (paymentType) {
            case IPS -> {
                return new IPSPay();
            }
            case AliPay -> {
                return new AliPay();
            }
            case Paypal -> {
                return new PaypalPay();
            }
            case Wechat -> {
                return new WechatPay();
            }
            default -> {
                return new ApplePay();
            }
        }
    }
}
