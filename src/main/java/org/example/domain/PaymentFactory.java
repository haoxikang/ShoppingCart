package org.example.domain;

import org.example.payment.*;

public class PaymentFactory {
    public static Payment newInstance(PaymentType paymentType) {
        switch (paymentType) {
            case IPS -> {
                return IPSPay()
            }
            case AliPay -> {
                return AliPay()
            }
            case Paypal -> {
                return PaypalPay()
            }
            case Wechat -> {
                return WechatPay()
            }
            case ApplePay -> {
                return ApplePay()
            }
        }
    }
}
