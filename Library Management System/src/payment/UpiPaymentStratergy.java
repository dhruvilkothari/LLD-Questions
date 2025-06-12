package payment;

public class UpiPaymentStratergy implements PaymentStratergy{
    @Override
    public boolean pay(int amount) {
        System.out.println("Paying " + amount + " using UPI");
        return true;
    }
}
