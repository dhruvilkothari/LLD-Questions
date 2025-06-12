package payment;

public class CardPaymentStratergy implements PaymentStratergy{
    @Override
    public boolean pay(int amount) {
        System.out.println("Paying " + amount + " using Card");
        return true;
    }
}
