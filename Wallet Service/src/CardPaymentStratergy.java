public class CardPaymentStratergy implements PaymentStratergy{
    @Override
    public void pay(int amount, Wallet wallet) {
        System.out.println("Payment done using Card for amount "+amount);
        wallet.depositMoney(amount);
    }
}
