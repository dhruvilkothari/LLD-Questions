    import java.util.ArrayList;
    import java.util.List;
    import java.util.UUID;

    public class Wallet {
        private final String id;
        private int balance;
        private String currency;
        private User user;
        private List<Transaction> transactions;
        private final Object lock = new Object();
        private final Object lock2 = new Object();

        public int getBalance(){
            return balance;
        }


        public Wallet( int balance, String currency, User user) {
            this.id = UUID.randomUUID().toString();
            this.balance = balance;
            this.currency = currency;
            this.user = user;
            this.transactions = new ArrayList<>();
        }


        public  void depositMoney(int amount) {
            synchronized (lock2){
                this.balance+=amount;
            }

        }
        public void printTransactionHistory() {
            System.out.println("Transaction History for Wallet ID: " + id);
            for (Transaction transaction : transactions) {
                System.out.println("Transaction ID: " + transaction.getTransactionId());
                System.out.println("Amount: " + transaction.getAmount());
                System.out.println("Date: " + transaction.getDate());
                System.out.println("Status: " + transaction.getStatus());
                System.out.println("Source: " + transaction.getSource());
                System.out.println("Destination: " + transaction.getDestination());
                System.out.println("BALANCE: "+ balance);
                System.out.println("-----------------------------");
            }
        }

        public boolean transferMoney(int amount, User to) {
            Wallet fromWallet = this;
            Wallet toWallet = to.getWallet();

            Transaction transaction = new Transaction(amount, user.getId(), to.getId());
            transaction.setStatus(TransactionStatus.PENDING);

            Wallet firstLock = fromWallet.id.compareTo(toWallet.id) < 0 ? fromWallet : toWallet;
            Wallet secondLock = fromWallet.id.compareTo(toWallet.id) < 0 ? toWallet : fromWallet;

            synchronized (firstLock.lock) {
                synchronized (secondLock.lock) {
                    if (fromWallet.balance < amount) {
                        transaction.setStatus(TransactionStatus.PENDING);
                        fromWallet.transactions.add(transaction); // Need to synchronize or use thread-safe list
                        return false;
                    }

                    fromWallet.balance -= amount;
                    toWallet.balance += amount;


                    System.out.println("Transaction successful for BALNCE after : " + balance);
                    System.out.println("Transaction successful for BALNCE after : " + toWallet.balance);

                    transaction.setStatus(TransactionStatus.COMPLETED);
                    fromWallet.transactions.add(transaction);
                    toWallet.transactions.add(transaction);

                    return true;
                }
            }
        }

//        public boolean transferMoney(int amount, User to) {
//
//            Transaction transaction = new Transaction(amount, user.getId(), to.getId());
//            transaction.setStatus(TransactionStatus.PENDING);
//
//            synchronized (lock) {
//                if (balance < amount) {
//                    transaction.setStatus(TransactionStatus.PENDING);
//                    transactions.add(transaction);
//                    return false;
//                }
//                balance -= amount;
//                transaction.setStatus(TransactionStatus.COMPLETED);
//                transactions.add(transaction);
//
//                to.getWallet().depositMoney(amount);
//                to.getWallet().transactions.add(transaction);
//                return true;
//
//            }
//
//        }
    }
