package org.example.payment;

public enum PaymentType {
    AliPay(new AliPay()),
    ApplePay(new ApplePay()),
    Paypal(new PaypalPay()),
    IPS(new IPSPay()),
    Wechat(new WechatPay()),
    Default(null);

    private final Payment payment;

    PaymentType(Payment payment) {
        this.payment = payment;
    }

    public Payment getPayment() {
        return payment;
    }

    public static PaymentType findType(String type) {
        PaymentType paymentType;
        try {
            paymentType = PaymentType.valueOf(type);
        } catch (IllegalArgumentException e) {
            paymentType = PaymentType.Default;
        }
        return paymentType;
    }
}
