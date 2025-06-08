package payment;

public class UpiPaymentStratergy implements PaymentStratergy{
    @Override
    public void pay(double amount) {
        System.out.println("Payment Done using upi of amount "+ amount );
    }
}
