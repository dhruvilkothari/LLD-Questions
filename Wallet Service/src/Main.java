import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        User user1 = new User("User1", "dk1@gmail.com", "INR");
        User user2 = new User("User2", "dk2@gmail.com", "INR");

        user1.addMoney(1000, new UpiPaymentStratergy());
        user2.addMoney(1000, new UpiPaymentStratergy());

        int numberOfThreads = 100;
        Thread[] threads = new Thread[numberOfThreads];

        // Create threads to transfer money concurrently
        for (int i = 0; i < numberOfThreads; i++) {
            if (i % 2 == 0) {
                threads[i] = new Thread(() -> user1.transferMoney(10, user2));
            } else {
                threads[i] = new Thread(() -> user2.transferMoney(10, user1));
            }
        }

        // Start all threads
        for (Thread thread : threads) {
            thread.start();
        }

        // Wait for all threads to complete
        for (Thread thread : threads) {
            thread.join();
        }
//        ExecutorService executor = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < 100; i++) {
//            executor.submit(() -> user1.transferMoney(10, user2));
//            executor.submit(() -> user2.transferMoney(10, user1));
//        }
//        executor.shutdown();
//        executor.awaitTermination(1, TimeUnit.MINUTES);

        // Print results
        System.out.println("Final Balance of User1: " + user1.getWallet().getBalance());
        System.out.println("Final Balance of User2: " + user2.getWallet().getBalance());

        System.out.println("\nUser1 Transactions:");
        user1.getWallet().printTransactionHistory();

        System.out.println("\nUser2 Transactions:");
        user2.getWallet().printTransactionHistory();

        assert user1.getWallet().getBalance() + user2.getWallet().getBalance() == 2000
                : "Total balance mismatch!";


    }
}