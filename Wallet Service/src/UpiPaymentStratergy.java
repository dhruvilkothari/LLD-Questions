public class UpiPaymentStratergy implements PaymentStratergy{
    @Override
    public void pay(int amount, Wallet wallet) {
        System.out.println("Payment done using UPI for amount "+amount);
        wallet.depositMoney(amount);
    }
}
