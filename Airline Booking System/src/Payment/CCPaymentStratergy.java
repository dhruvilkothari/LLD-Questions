package Payment;

public class CCPaymentStratergy implements PaymentStratergy{
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}
