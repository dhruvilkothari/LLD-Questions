public class CardPaymentStratergy implements PaymentStratergy{
    @Override
    public void pay(int amount) {
        System.out.println("Payment Using Card " + amount);
    }
}
