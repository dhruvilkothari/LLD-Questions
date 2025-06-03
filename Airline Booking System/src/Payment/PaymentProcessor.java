package Payment;

public class PaymentProcessor {

    private PaymentStratergy paymentStratergy;

    public PaymentProcessor(PaymentStratergy paymentStratergy) {
        this.paymentStratergy = paymentStratergy;
    }
    public void processPayment(double amount) {
        paymentStratergy.pay(amount);
    }

}
