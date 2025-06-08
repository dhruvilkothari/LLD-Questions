package payment;

public class PaymentProcessor {
    private PaymentStratergy paymentStratergy;

    public PaymentProcessor(){
        paymentStratergy = new UpiPaymentStratergy();
    }
    public void processPayment(double amount){
        paymentStratergy.pay(amount);
    }
    public void setPaymentStratergy(PaymentStratergy paymentStratergy){
        this.paymentStratergy = paymentStratergy;
    }

}
