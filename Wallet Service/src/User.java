import java.util.UUID;

public class User {
    private final String id;
    private final String name;
    private final String email;
    private final Wallet wallet;

    public User(String name, String email,String currency) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.wallet = new Wallet(0, currency, this);
    }

    public void addMoney(int amount, PaymentStratergy paymentStratergy){
        paymentStratergy.pay(amount, this.wallet);
    }
    public void transferMoney(int amount, User to){
        boolean flag = wallet.transferMoney(amount, to);
        if(flag){
            System.out.println("Transaction successful");
        }else{
            System.out.println("Transaction failed");
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Wallet getWallet() {
        return wallet;
    }
}
