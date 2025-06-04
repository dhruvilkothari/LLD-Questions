package payment;

public class CashPaymentStratergy implements PaymentStratergy{
    @Override
    public boolean pay(int amount) {
        System.out.println("Paying Using Cash "+ amount);
        return true;
    }
}
