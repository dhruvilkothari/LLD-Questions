import payment.PaymentProcessor;

import java.util.HashMap;

public class LibraryManager {
    private final BookManager  bookManager;
    private PaymentProcessor paymentProcessor;

    public LibraryManager() {
        bookManager = BookManager.getInstance();
        paymentProcessor = new PaymentProcessor();
    }
    public void addBook(Book book, int quantity) {
        bookManager.addBook(book, quantity);
    }
    public void rentBook(Book book, User user) {

    }
}
