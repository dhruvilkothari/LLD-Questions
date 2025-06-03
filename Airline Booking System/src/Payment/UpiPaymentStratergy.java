package Payment;

public class UpiPaymentStratergy implements PaymentStratergy{
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}
