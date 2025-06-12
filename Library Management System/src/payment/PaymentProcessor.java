package payment;

public class PaymentProcessor {
    private PaymentStratergy paymentStratergy;
    public PaymentProcessor(PaymentStratergy paymentStratergy){
        this.paymentStratergy = paymentStratergy;
    }

    public boolean pay(int amount){
        return paymentStratergy.pay(amount);
    }
    public void setPaymentStratergy(PaymentStratergy paymentStratergy){
        this.paymentStratergy = paymentStratergy;
    }
}
