package payment;

public class CCPaymentStatergy implements PaymentStratergy{
    @Override
    public boolean pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
        return true;
    }
}
