package payment;

public class UpiPaymentStratergy implements PaymentStratergy{
    @Override
    public boolean pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
        return true;
    }
}
